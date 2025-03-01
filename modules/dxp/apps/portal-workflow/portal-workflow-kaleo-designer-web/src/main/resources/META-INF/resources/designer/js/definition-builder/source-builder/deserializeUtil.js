/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 */

import {defaultLanguageId} from '../constants';
import {removeNewLine, replaceTabSpaces} from '../util/utils';
import {DEFAULT_LANGUAGE} from './constants';
import XMLDefinition from './xmlDefinition';

export default function DeserializeUtil(content) {
	const instance = this;

	instance.definition = new XMLDefinition({
		value: content,
	});
}

DeserializeUtil.prototype = {
	getElements() {
		const instance = this;

		const elements = [];

		instance.definition.forEachField((tagName, fieldData) => {
			fieldData.results.forEach((node) => {
				const position = {};
				let type = tagName;

				if (node.initial) {
					type = 'start';
				}

				const metadata = JSON.parse(node.metadata);

				if (metadata.terminal) {
					type = 'end';
				}

				position.x = metadata.xy[0];
				position.y = metadata.xy[1];

				let label = {};

				if (Array.isArray(node.labels)) {
					node.labels?.map((itemLabel) => {
						Object.entries(itemLabel).map(([key, value]) => {
							label[key] = replaceTabSpaces(removeNewLine(value));
						});
					});
				}
				else {
					label = {[defaultLanguageId]: node.name};
				}

				const data = {
					description: node.description,
					label,
					script: node.script,
				};

				if (type === 'task') {
					data.scriptLanguage =
						node.scriptLanguage || DEFAULT_LANGUAGE;
				}

				let nodeId;

				if (node.id) {
					nodeId = node.id;
				}
				else if (node.name) {
					nodeId = node.name;
				}
				else {
					return;
				}

				// To be removed after next stories

				if (
					type !== 'start' &&
					type !== 'end' &&
					type !== 'state' &&
					type !== 'task'
				) {
					type = 'state';
				}

				elements.push({
					data,
					id: nodeId,
					position,
					type,
				});

				if (node.transitions) {
					node.transitions.forEach((transition) => {
						let label = {};

						if (Array.isArray(transition.labels)) {
							transition.labels?.map((itemLabel) => {
								Object.entries(itemLabel).map(
									([key, value]) => {
										label[key] = replaceTabSpaces(
											removeNewLine(value)
										);
									}
								);
							});
						}
						else {
							label = {[defaultLanguageId]: transition.name};
						}

						let transitionId;

						if (transition.id) {
							transitionId = transition.id;
						}
						else if (transition.name) {
							transitionId = transition.name;
						}
						else {
							return;
						}

						elements.push({
							arrowHeadType: 'arrowclosed',
							data: {
								defaultEdge: JSON.parse(transition.default),
								label,
							},
							id: transitionId,
							source: nodeId,
							target: transition.target,
							type: 'transition',
						});
					});
				}
			});
		});

		return elements;
	},

	getMetadata() {
		const instance = this;

		return instance.definition.getDefinitionMetadata();
	},

	updateXMLDefinition(content) {
		const instance = this;

		instance.definition = new XMLDefinition({
			value: content,
		});
	},
};
