#!/usr/bin/perl

use strict;
use warnings;

use Win32::GuiTest qw(MouseMoveAbsPix SendMouse);

MouseMoveAbsPix(640,400);
SendMouse ("{LEFTCLICK}");


__END__
