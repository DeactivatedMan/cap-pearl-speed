## Why use this plugin
You may just want to make ender pearls slower to reduce their range and make them less overpowered. Though the main focus of this plugin is to try prevent players from abusing the chunkloading capabilities of pearls to lag the server.

## What this plugin does
This plugin limits ender pearls to always be under a certain speed. The cap and how often the check runs can be configured in the config.yml file, you can even choose to remove speeding pearls too. The default of 3 should only affect pearls shot by a cannon or fast-moving player. If you wish to tweak the speed limit then you should enable `dev-mode` as this logs every pearl's speed, making it easier for you to determine the right value for your application.

## Config
`max-speed` - The (roughly) maximum speed a pearl can travel with this plugin
`kill-pearl` - Destroys any speeding pearls if enabled
`run-every` - How many ticks between speed checks, 20 means one check a second
`dev-mode` - Logs every pearl's speed, only enable when tweaking the max speed