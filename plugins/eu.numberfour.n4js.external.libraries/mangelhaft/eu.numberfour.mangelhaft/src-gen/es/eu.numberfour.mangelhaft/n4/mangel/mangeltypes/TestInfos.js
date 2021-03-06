(function(System) {
	'use strict';
	System.register([], function($n4Export) {
		var TestInfos;
		TestInfos = function TestInfos() {
			this.sessionId = undefined;
			this.endpoint = "NO_ENDPOINT";
			this.testDescriptors = undefined;
		};
		$n4Export('TestInfos', TestInfos);
		return {
			setters: [],
			execute: function() {
				$makeClass(TestInfos, N4Object, [], {
					sessionId: {
						value: undefined,
						writable: true
					},
					endpoint: {
						value: undefined,
						writable: true
					},
					testDescriptors: {
						value: undefined,
						writable: true
					}
				}, {}, function(instanceProto, staticProto) {
					var metaClass = new N4Class({
						name: 'TestInfos',
						origin: 'eu.numberfour.mangelhaft',
						fqn: 'n4.mangel.mangeltypes.TestInfos.TestInfos',
						n4superType: N4Object.n4type,
						allImplementedInterfaces: [],
						ownedMembers: [
							new N4DataField({
								name: 'sessionId',
								isStatic: false,
								annotations: []
							}),
							new N4DataField({
								name: 'endpoint',
								isStatic: false,
								annotations: []
							}),
							new N4DataField({
								name: 'testDescriptors',
								isStatic: false,
								annotations: []
							})
						],
						consumedMembers: [],
						annotations: []
					});
					return metaClass;
				});
			}
		};
	});
})(typeof module !== 'undefined' && module.exports ? require('n4js-node/index').System(require, module) : System);
//# sourceMappingURL=TestInfos.map
