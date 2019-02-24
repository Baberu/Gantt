/*
@license

dhtmlxGantt v.6.1.0 Standard
This software is covered by GPL license. You also can obtain Commercial or Enterprise license to use it in non-GPL project - please contact sales@dhtmlx.com. Usage without proper license is prohibited.

(c) Dinamenta, UAB.

*/
!function(e,t){if("object"==typeof exports&&"object"==typeof module)module.exports=t();else if("function"==typeof define&&define.amd)define([],t);else{var n=t();for(var o in n)("object"==typeof exports?exports:e)[o]=n[o]}}(window,function(){return function(e){var t={};function n(o){if(t[o])return t[o].exports;var l=t[o]={i:o,l:!1,exports:{}};return e[o].call(l.exports,l,l.exports,n),l.l=!0,l.exports}return n.m=e,n.c=t,n.d=function(e,t,o){n.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:o})},n.r=function(e){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},n.t=function(e,t){if(1&t&&(e=n(e)),8&t)return e;if(4&t&&"object"==typeof e&&e&&e.__esModule)return e;var o=Object.create(null);if(n.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var l in e)n.d(o,l,function(t){return e[t]}.bind(null,l));return o},n.n=function(e){var t=e&&e.__esModule?function(){return e.default}:function(){return e};return n.d(t,"a",t),t},n.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},n.p="/codebase/",n(n.s=213)}({213:function(e,t){!function(){var e=gantt.getState;function t(){var e=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement;return e&&e===gantt.$root}gantt.getState=function(){var n=e.apply(this,arguments);return n.fullscreen=t(),n};var n=!1,o={width:null,height:null,modified:!1};function l(){gantt.$container&&(t()?(n=!0,function(){var e=gantt.$root;e.offsetWidth<window.innerWidth&&(o.width=e.style.width,o.height=e.style.height,e.style.width="100vw",e.style.height="100vh",o.modified=!0)}(),setTimeout(function(){gantt.callEvent("onExpand")})):n&&(n=!1,function(){var e=gantt.$root;o.modified&&(e.style.width=o.width,e.style.height=o.height,o.modified=!1)}(),setTimeout(function(){gantt.callEvent("onCollapse")})))}function u(){return!gantt.$container||!(document.fullscreenEnabled||document.webkitFullscreenEnabled||document.mozFullScreenEnabled||document.msFullscreenEnabled)&&((console.warning||console.log)("The `fullscreen` feature not being allowed, or full-screen mode not being supported"),!0)}gantt.event(document,"webkitfullscreenchange",l),gantt.event(document,"mozfullscreenchange",l),gantt.event(document,"MSFullscreenChange",l),gantt.event(document,"fullscreenChange",l),gantt.event(document,"fullscreenchange",l),gantt.expand=function(){if(!u()&&gantt.callEvent("onBeforeExpand",[])){var e=gantt.$root;e.requestFullscreen?e.requestFullscreen():e.msRequestFullscreen?e.msRequestFullscreen():e.mozRequestFullScreen?e.mozRequestFullScreen():e.webkitRequestFullscreen&&e.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT)}},gantt.collapse=function(){u()||t()&&gantt.callEvent("onBeforeCollapse",[])&&(document.exitFullscreen?document.exitFullscreen():document.msExitFullscreen?document.msExitFullscreen():document.mozCancelFullScreen?document.mozCancelFullScreen():document.webkitExitFullscreen&&document.webkitExitFullscreen())}}()}})});
//# sourceMappingURL=dhtmlxgantt_fullscreen.js.map