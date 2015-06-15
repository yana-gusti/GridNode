#!/bin/bash


echo 1  | sudo -S useradd -m -s /bin/bash -p $(echo 1 | openssl passwd -1 -stdin) qaz

sudo usermod -aG sudo,adm qaz


sleep 2


