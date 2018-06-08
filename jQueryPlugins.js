if(typeof $telerik.$==="undefined"){$telerik.$=jQuery;
/*
 * jQuery Easing v1.3 - http://gsgd.co.uk/sandbox/jquery/easing/
 *
 * TERMS OF USE - jQuery Easing
 * 
 * Open source under the BSD License. 
 * 
 * Copyright © 2008 George McGinley Smith
 * All rights reserved.
*/
/*
 * TERMS OF USE - EASING EQUATIONS
 * 
 * Open source under the BSD License. 
 * 
 * Copyright © 2001 Robert Penner
 * All rights reserved.
 */
}(function(a){a.easing.jswing=a.easing.swing;
a.extend(a.easing,{def:"easeOutQuad",swing:function(i,h,e,f,g){return a.easing[a.easing.def](i,h,e,f,g);
},easeLinear:function(i,h,e,f,g){return f*h/g+e;
},easeInQuad:function(i,h,e,f,g){return f*(h/=g)*h+e;
},easeOutQuad:function(i,h,e,f,g){return -f*(h/=g)*(h-2)+e;
},easeInOutQuad:function(i,h,e,f,g){if((h/=g/2)<1){return f/2*h*h+e;
}return -f/2*((--h)*(h-2)-1)+e;
},easeInCubic:function(i,h,e,f,g){return f*(h/=g)*h*h+e;
},easeOutCubic:function(i,h,e,f,g){return f*((h=h/g-1)*h*h+1)+e;
},easeInOutCubic:function(i,h,e,f,g){if((h/=g/2)<1){return f/2*h*h*h+e;
}return f/2*((h-=2)*h*h+2)+e;
},easeInQuart:function(i,h,e,f,g){return f*(h/=g)*h*h*h+e;
},easeOutQuart:function(i,h,e,f,g){return -f*((h=h/g-1)*h*h*h-1)+e;
},easeInOutQuart:function(i,h,e,f,g){if((h/=g/2)<1){return f/2*h*h*h*h+e;
}return -f/2*((h-=2)*h*h*h-2)+e;
},easeInQuint:function(i,h,e,f,g){return f*(h/=g)*h*h*h*h+e;
},easeOutQuint:function(i,h,e,f,g){return f*((h=h/g-1)*h*h*h*h+1)+e;
},easeInOutQuint:function(i,h,e,f,g){if((h/=g/2)<1){return f/2*h*h*h*h*h+e;
}return f/2*((h-=2)*h*h*h*h+2)+e;
},easeInSine:function(i,h,e,f,g){return -f*Math.cos(h/g*(Math.PI/2))+f+e;
},easeOutSine:function(i,h,e,f,g){return f*Math.sin(h/g*(Math.PI/2))+e;
},easeInOutSine:function(i,h,e,f,g){return -f/2*(Math.cos(Math.PI*h/g)-1)+e;
},easeInExpo:function(i,h,e,f,g){return(h==0)?e:f*Math.pow(2,10*(h/g-1))+e;
},easeOutExpo:function(i,h,e,f,g){return(h==g)?e+f:f*(-Math.pow(2,-10*h/g)+1)+e;
},easeInOutExpo:function(i,h,e,f,g){if(h==0){return e;
}if(h==g){return e+f;
}if((h/=g/2)<1){return f/2*Math.pow(2,10*(h-1))+e;
}return f/2*(-Math.pow(2,-10*--h)+2)+e;
},easeInCirc:function(i,h,e,f,g){return -f*(Math.sqrt(1-(h/=g)*h)-1)+e;
},easeOutCirc:function(i,h,e,f,g){return f*Math.sqrt(1-(h=h/g-1)*h)+e;
},easeInOutCirc:function(i,h,e,f,g){if((h/=g/2)<1){return -f/2*(Math.sqrt(1-h*h)-1)+e;
}return f/2*(Math.sqrt(1-(h-=2)*h)+1)+e;
},easeInElastic:function(l,k,f,g,h){var j=1.70158;
var i=0;
var e=g;
if(k==0){return f;
}if((k/=h)==1){return f+g;
}if(!i){i=h*0.3;
}if(e<Math.abs(g)){e=g;
var j=i/4;
}else{var j=i/(2*Math.PI)*Math.asin(g/e);
}return -(e*Math.pow(2,10*(k-=1))*Math.sin((k*h-j)*(2*Math.PI)/i))+f;
},easeOutElastic:function(l,k,f,g,h){var j=1.70158;
var i=0;
var e=g;
if(k==0){return f;
}if((k/=h)==1){return f+g;
}if(!i){i=h*0.3;
}if(e<Math.abs(g)){e=g;
var j=i/4;
}else{var j=i/(2*Math.PI)*Math.asin(g/e);
}return e*Math.pow(2,-10*k)*Math.sin((k*h-j)*(2*Math.PI)/i)+g+f;
},easeInOutElastic:function(l,k,f,g,h){var j=1.70158;
var i=0;
var e=g;
if(k==0){return f;
}if((k/=h/2)==2){return f+g;
}if(!i){i=h*(0.3*1.5);
}if(e<Math.abs(g)){e=g;
var j=i/4;
}else{var j=i/(2*Math.PI)*Math.asin(g/e);
}if(k<1){return -0.5*(e*Math.pow(2,10*(k-=1))*Math.sin((k*h-j)*(2*Math.PI)/i))+f;
}return e*Math.pow(2,-10*(k-=1))*Math.sin((k*h-j)*(2*Math.PI)/i)*0.5+g+f;
},easeInBack:function(j,i,e,f,g,h){if(h==undefined){h=1.70158;
}return f*(i/=g)*i*((h+1)*i-h)+e;
},easeOutBack:function(j,i,e,f,g,h){if(h==undefined){h=1.70158;
}return f*((i=i/g-1)*i*((h+1)*i+h)+1)+e;
},easeInOutBack:function(j,i,e,f,g,h){if(h==undefined){h=1.70158;
}if((i/=g/2)<1){return f/2*(i*i*(((h*=(1.525))+1)*i-h))+e;
}return f/2*((i-=2)*i*(((h*=(1.525))+1)*i+h)+2)+e;
},easeInBounce:function(i,h,e,f,g){return f-a.easing.easeOutBounce(i,g-h,0,f,g)+e;
},easeOutBounce:function(i,h,e,f,g){if((h/=g)<(1/2.75)){return f*(7.5625*h*h)+e;
}else{if(h<(2/2.75)){return f*(7.5625*(h-=(1.5/2.75))*h+0.75)+e;
}else{if(h<(2.5/2.75)){return f*(7.5625*(h-=(2.25/2.75))*h+0.9375)+e;
}else{return f*(7.5625*(h-=(2.625/2.75))*h+0.984375)+e;
}}}},easeInOutBounce:function(i,h,e,f,g){if(h<g/2){return a.easing.easeInBounce(i,h*2,0,f,g)*0.5+e;
}return a.easing.easeOutBounce(i,h*2-g,0,f,g)*0.5+f*0.5+e;
}});
})($telerik.$);
/*
 * jQuery throttle / debounce - v1.1 - 3/7/2010
 * http://benalman.com/projects/jquery-throttle-debounce-plugin/
 *
 * Copyright (c) 2010 "Cowboy" Ben Alman
 * Dual licensed under the MIT and GPL licenses.
 * http://benalman.com/about/license/
 */
(function(d,c){var a=$telerik.$||d.Cowboy||(d.Cowboy={}),b;
a.throttle=b=function(g,i,e,f){var j,h=0;
if(typeof i!=="boolean"){f=e;
e=i;
i=c;
}function k(){var p=this,n=+new Date()-h,l=arguments;
function o(){h=+new Date();
e.apply(p,l);
}function m(){j=c;
}if(f&&!j){o();
}j&&clearTimeout(j);
if(f===c&&n>g){o();
}else{if(i!==true){j=setTimeout(f?m:o,f===c?g-n:g);
}}}if(a.guid){k.guid=e.guid=e.guid||a.guid++;
}return k;
};
a.debounce=function(g,e,f){return f===c?b(g,e,false):b(g,f,e!==false);
};
})(window);
(function(b){b.fx.step.height=function(e){var f=$telerik.quirksMode?1:0;
var g=e.now>f?e.now:f;
e.elem.style[e.prop]=Math.round(g)+e.unit;
};
function c(f,e){return["live",f,e.replace(/\./g,"`").replace(/ /g,"|")].join(".");
}function a(f,e){b.each(e,function(g,h){if(g.indexOf("et_")>0){f[g]=h;
return;
}if(g=="domEvent"&&h){f["get_"+g]=function(){return new Sys.UI.DomEvent(h.originalEvent||h.rawEvent||h);
};
}else{f["get_"+g]=function(i){return function(){return i;
};
}(h);
}});
return f;
}b.extend({registerControlEvents:function(e,f){b.each(f,function(h,g){e.prototype["add_"+g]=function(i){this.get_events().addHandler(g,i);
};
e.prototype["remove_"+g]=function(i){this.get_events().removeHandler(g,i);
};
});
},registerControlProperties:function(e,f){b.each(f,function(h,g){e.prototype["get_"+h]=function(){var i=this["_"+h];
return typeof i=="undefined"?g:i;
};
e.prototype["set_"+h]=function(i){this["_"+h]=i;
};
});
},registerEnum:function(f,e,g){f[e]=function(){};
f[e].prototype=g;
f[e].registerEnum(f.getName()+"."+e);
},raiseControlEvent:function(f,g,e){var h=f.get_events().getHandler(g);
if(h){h(f,a(new Sys.EventArgs(),e));
}},raiseCancellableControlEvent:function(g,h,e){var i=g.get_events().getHandler(h);
if(i){var f=a(new Sys.CancelEventArgs(),e);
i(g,f);
return f.get_cancel();
}return false;
},extendEventArgs:function(e,f){return a(e,f);
},isBogus:function(e){try{var g=e.parentNode;
return false;
}catch(f){return true;
}}});
b.eachCallback=function(e,g){var f=0;
function h(){if(e.length==0){return;
}var i=e[f];
g.apply(i);
f++;
if(f<e.length){setTimeout(h,1);
}}setTimeout(h,1);
};
b.fn.eachCallback=function(g){var e=0;
var f=this;
function h(){if(f.length==0){return;
}var i=f.get(e);
g.apply(i);
e++;
if(e<f.length){setTimeout(h,1);
}}setTimeout(h,1);
};
if($telerik.isTouchDevice){var d;
b.each(["t_touchover","t_touchout"],function(e,f){b.fn[f]=function(g){return this.bind(f,g);
};
});
b(document.body).bind("touchstart",function(f){d=f.originalEvent.currentTarget;
}).bind("touchmove",function(f){var i=f.originalEvent.changedTouches[0],h=document.elementFromPoint(i.clientX,i.clientY);
if(d!=h){var g={target:d,relatedTarget:d,CtrlKey:false,AltKey:false,ShiftKey:false};
b(d).trigger("t_touchout",g);
d=h;
b(d).trigger("t_touchover",b.extend(g,{target:d,relatedTarget:d}));
}});
}})($telerik.$);
/*
* jQuery Double Tap Plugin.
*
* Copyright (c) 2010 Raul Sanchez (http://www.appcropolis.com)
*
* Dual licensed under the MIT and GPL licenses:
* http://www.opensource.org/licenses/mit-license.php
* http://www.gnu.org/licenses/gpl.html
*/
(function(a){a.fn.doubletap=function(e,f,c){var d,b;
c=c==null?500:c;
d=$telerik.isTouchDevice?"touchend":"click";
a(this).bind(d,function(h){var j=new Date().getTime();
var i=a(this).data("lastTouch")||j+1;
var g=j-i;
clearTimeout(b);
if(g<500&&g>0){if(e!=null&&typeof e=="function"){e(h);
}}else{a(this).data("lastTouch",j);
b=setTimeout(function(k){if(f!=null&&typeof f=="function"){f(k);
}clearTimeout(b);
},c,[h]);
}a(this).data("lastTouch",j);
});
};
})($telerik.$);
