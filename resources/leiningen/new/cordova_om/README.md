# {{name}}

Hello World in Cordova from ClojureScript, with Om and Sablono.

Thanks to Keith Irwin for working initialization code https://gist.github.com/zentrope/bf359cec33f6fcc02be4

## Create the Cordova Wrapper and Build the JavaScript

% cordova create cordova-proj com.yourname.{{name}} {{capitalized}}
% rm cordova-proj/www/js/index.js
% cp index.html cordova-proj/www
% (cd cordova-proj; cordova platform add android)
% cljsbuild once phone-dev

## Build and Run the Debug APK

% cd cordova-proj
% cordova run android

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
