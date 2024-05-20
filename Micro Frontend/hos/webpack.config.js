const { shareAll, withModuleFederationPlugin } = require('@angular-architects/module-federation/webpack');

module.exports = withModuleFederationPlugin({

  remotes: {
    // "mfe1": "http://localhost:3000/remoteEntry.js",
    "mfe1":"mfe1@http://localhost:4002/remoteEntry.js",
    "mfe2":"mfe2@http://localhost:4003/remoteEntry.js",
    "EM":"EM@http://localhost:4004/remoteEntry.js"

  },

  shared: {
    ...shareAll({ singleton: true, strictVersion: true, requiredVersion: 'auto' }),
  },

});
