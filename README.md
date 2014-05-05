# bashpipe

This small experiment maintains a long-lived bash process used to
execute system commands. The objective is not having to spawn a
process for every call like clojure.java.shell.

## Usage

```
(bashpipe.core/sh "ls" "-la")
```

## Issues

Having a single bash process means that commands are executed sequentially and that if one command hangs, it will block all other commands.

A named pipe is created in the mechanism of communication with the bash process. That named pipe is never removed.

## License

Copyright © 2014 Jean-Sebastien A. Beaudry

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
