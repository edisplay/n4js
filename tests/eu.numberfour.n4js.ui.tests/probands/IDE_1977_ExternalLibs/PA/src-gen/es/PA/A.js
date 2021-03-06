(function(System) {
	'use strict';
	System.register([], function($n4Export) {
		var A;
		A = function A() {
			console.log('External A<init>');
		};
		$n4Export('A', A);
		return {
			setters: [],
			execute: function() {
				$makeClass(A, Object, [], {}, {}, function(instanceProto, staticProto) {
					var metaClass = new N4Class({
						name: 'A',
						origin: 'PA',
						fqn: 'A.A',
						n4superType: N4Object.n4type,
						allImplementedInterfaces: [],
						ownedMembers: [
							new N4Method({
								name: 'constructor',
								isStatic: false,
								jsFunction: instanceProto['constructor'],
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
//# sourceMappingURL=A.map
