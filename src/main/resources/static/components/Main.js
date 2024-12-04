//DO NOT 'import Vue from "vue"' - doesn't work without Vite

import GlobalComponent from '/components/globalComponent.js'; //remove 'static/' and remember to write .js or, it won't find the file -_-

// Globally register the component
Vue.component('global-component', GlobalComponent);

// Initialize Vue
new Vue({
    el: '#app',
    data: {
        appMessage: 'Hello from Main.js!',
    },
});
