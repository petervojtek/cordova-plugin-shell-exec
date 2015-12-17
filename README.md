# cordova-plugin-shell-exec

Apache Cordova Plugin to Execute Commands in Smartphone's Operating System Shell

### Supported Platforms

* Android

### Installation

`$ cordova plugin add https://github.com/petervojtek/cordova-plugin-shell-exec.git`

### Usage

```
window.ShellExec.exec(cmd, callback)
```

callback function will return a hash with two keys - `exitStatus` and `output`.

Example:

```
window.ShellExec.exec('uptime', function(res){
  console.log('exit status: ' + res.exitStatus)
  console.log('cmd output: ' + res.output)
})
```

JS console output:
```
exit status: 0
cmd output: up time: 10 days, 05:16:51, idle time: 17 days, 01:22:57, sleep time: 5 days, 16:38:37
```

If command execution fails (e.g. you enter wrong command), you receive exit status `100`.

### Notes

* Currently plugin works properly only in user mode. Some [code tweaks](http://stackoverflow.com/a/6882295/4606227) are needed to run commands as root (I do not have a rooted Android phone to test it).

### How to Contribute

Use pull request.
