#!/bin/sh
unset UBUNTU_MENUPROXY
export GDK_NATIVE_WINDOWS=1
export SWT_GTK3=0
if [ "a" = "a$(uname -m | grep 64)" ]; then # computer is 32-bits
	./TOS_DI-linux-gtk-x86
else
	./TOS_DI-linux-gtk-x86_64
fi
