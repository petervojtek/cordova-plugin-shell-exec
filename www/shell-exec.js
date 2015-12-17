function ShellExec() {
  this.exec = function(cmd, callback) {
    return cordova.exec(callback, function(err) {
      callback({exitStatus: 100, output: err});
    }, "ShellExec", "exec", [cmd]);

  };
}

window.ShellExec = new ShellExec()
