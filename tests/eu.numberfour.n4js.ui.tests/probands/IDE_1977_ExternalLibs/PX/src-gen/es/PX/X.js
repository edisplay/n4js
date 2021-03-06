(function(System) {
	'use strict';
	System.register([], function($n4Export) {
		var X;
		X = function X() {
			console.log('External X<init>');
		};
		$n4Export('X', X);
		return {
			setters: [],
			execute: function() {
				$makeClass(X, Object, [], {}, {}, function(instanceProto, staticProto) {
					var metaClass = new N4Class({
						name: 'X',
						origin: 'PX',
						fqn: 'X.X',
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
//# sourceMappingURL=X.map
