/*
@license

dhtmlxGantt v.6.1.0 Standard
This software is covered by GPL license. You also can obtain Commercial or Enterprise license to use it in non-GPL project - please contact sales@dhtmlx.com. Usage without proper license is prohibited.

(c) Dinamenta, UAB.

*/
!function(t,e){if("object"==typeof exports&&"object"==typeof module)module.exports=e();else if("function"==typeof define&&define.amd)define([],e);else{var n=e();for(var o in n)("object"==typeof exports?exports:t)[o]=n[o]}}(window,function(){return function(t){var e={};function n(o){if(e[o])return e[o].exports;var r=e[o]={i:o,l:!1,exports:{}};return t[o].call(r.exports,r,r.exports,n),r.l=!0,r.exports}return n.m=t,n.c=e,n.d=function(t,e,o){n.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:o})},n.r=function(t){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},n.t=function(t,e){if(1&e&&(t=n(t)),8&e)return t;if(4&e&&"object"==typeof t&&t&&t.__esModule)return t;var o=Object.create(null);if(n.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)n.d(o,r,function(e){return t[e]}.bind(null,r));return o},n.n=function(t){var e=t&&t.__esModule?function(){return t.default}:function(){return t};return n.d(e,"a",e),e},n.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},n.p="/codebase/",n(n.s=190)}({190:function(t,e){gantt.config.day_date="%M %d日 %D",gantt.config.default_date="%Y年 %M %d日",gantt.config.month_date="%Y年 %M",gantt.locale={date:{month_full:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],month_short:["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],day_full:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],day_short:["日","一","二","三","四","五","六"]},labels:{new_task:"新任務",dhx_cal_today_button:"今天",day_tab:"日",week_tab:"周",month_tab:"月",new_event:"新建日程",icon_save:"保存",icon_cancel:"关闭",icon_details:"详细",icon_edit:"编辑",icon_delete:"删除",confirm_closing:"请确认是否撤销修改!",confirm_deleting:"是否删除日程?",section_description:"描述",section_time:"时间范围",section_type:"类型",column_wbs:"工作分解结构",column_text:"任务名",column_start_date:"开始时间",column_duration:"持续时间",column_add:"",link:"关联",confirm_link_deleting:"将被删除",link_start:" (开始)",link_end:" (结束)",type_task:"任务",type_project:"项目",type_milestone:"里程碑",minutes:"分钟",hours:"小时",days:"天",weeks:"周",months:"月",years:"年",message_ok:"OK",message_cancel:"关闭",section_constraint:"Constraint",constraint_type:"Constraint type",constraint_date:"Constraint date",asap:"As Soon As Possible",alap:"As Late As Possible",snet:"Start No Earlier Than",snlt:"Start No Later Than",fnet:"Finish No Earlier Than",fnlt:"Finish No Later Than",mso:"Must Start On",mfo:"Must Finish On"}}}})});
//# sourceMappingURL=locale_cn.js.map