/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

import com.liferay.jenkins.results.parser.job.property.JobProperty;
import com.liferay.jenkins.results.parser.test.clazz.group.AxisTestClassGroup;
import com.liferay.jenkins.results.parser.test.clazz.group.BatchTestClassGroup;
import com.liferay.jenkins.results.parser.test.clazz.group.SegmentTestClassGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author Yi-Chen Tsai
 */
public abstract class PortalAcceptanceTestSuiteJob
	extends PortalGitRepositoryJob implements BatchDependentJob, TestSuiteJob {

	public PortalAcceptanceTestSuiteJob(
		String jobName, BuildProfile buildProfile, String testSuiteName,
		String branchName) {

		super(jobName, buildProfile, branchName);

		if (testSuiteName == null) {
			testSuiteName = "default";
		}

		_testSuiteName = testSuiteName;
	}

	@Override
	public List<AxisTestClassGroup> getDependentAxisTestClassGroups() {
		List<AxisTestClassGroup> axisTestClassGroups = new ArrayList<>();

		for (BatchTestClassGroup batchTestClassGroup :
				getDependentBatchTestClassGroups()) {

			axisTestClassGroups.addAll(
				batchTestClassGroup.getAxisTestClassGroups());
		}

		return axisTestClassGroups;
	}

	@Override
	public Set<String> getDependentBatchNames() {
		return getFilteredBatchNames(getRawDependentBatchNames());
	}

	@Override
	public List<BatchTestClassGroup> getDependentBatchTestClassGroups() {
		return getBatchTestClassGroups(getRawDependentBatchNames());
	}

	@Override
	public Set<String> getDependentSegmentNames() {
		return getFilteredSegmentNames(getRawDependentBatchNames());
	}

	@Override
	public List<SegmentTestClassGroup> getDependentSegmentTestClassGroups() {
		return getSegmentTestClassGroups(getRawDependentBatchNames());
	}

	@Override
	public DistType getDistType() {
		String distType = JenkinsResultsParserUtil.getProperty(
			getJobProperties(), "dist.type[" + _testSuiteName + "]");

		if ((distType == null) && _testSuiteName.equals("default")) {
			distType = JenkinsResultsParserUtil.getProperty(
				getJobProperties(), "dist.type");
		}

		if (distType == null) {
			return DistType.CI;
		}

		for (DistType distTypeValue : DistType.values()) {
			if (distType.equals(distTypeValue.toString())) {
				return distTypeValue;
			}
		}

		return DistType.CI;
	}

	@Override
	public Set<String> getDistTypes() {
		Properties jobProperties = getJobProperties();

		String testBatchDistAppServers = JenkinsResultsParserUtil.getProperty(
			jobProperties,
			"test.batch.dist.app.servers[" + _testSuiteName + "]");

		if (testBatchDistAppServers == null) {
			testBatchDistAppServers = JenkinsResultsParserUtil.getProperty(
				jobProperties, "test.batch.dist.app.servers");
		}

		Set<String> testBatchDistAppServersSet = getSetFromString(
			testBatchDistAppServers);

		if (!_testSuiteName.equals("relevant")) {
			return testBatchDistAppServersSet;
		}

		String stableTestBatchDistAppServers =
			JenkinsResultsParserUtil.getProperty(
				jobProperties, "test.batch.dist.app.servers[stable]");

		if (stableTestBatchDistAppServers != null) {
			testBatchDistAppServersSet.addAll(
				getSetFromString(stableTestBatchDistAppServers));
		}

		return testBatchDistAppServersSet;
	}

	@Override
	public String getTestSuiteName() {
		return _testSuiteName;
	}

	@Override
	protected Set<String> getRawBatchNames() {
		Set<String> rawBatchNames = super.getRawBatchNames();

		if (!_testSuiteName.equals("relevant")) {
			return rawBatchNames;
		}

		JobProperty jobProperty = getJobProperty("test.batch.names[stable]");

		rawBatchNames.addAll(getSetFromString(jobProperty.getValue()));

		return rawBatchNames;
	}

	protected Set<String> getRawDependentBatchNames() {
		JobProperty batchJobProperty = getJobProperty("test.batch.names.smoke");

		return getSetFromString(batchJobProperty.getValue());
	}

	private final String _testSuiteName;

}