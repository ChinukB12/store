let itemApi = Vue.resource('/items{/id}')

Vue.component('item-row', {
    props: ['item'],
    template: '<div><i>({{ item.id }})</i> {{ item.name }} </div>'
})

Vue.component('item-list', {
        props: ['items'],
        template: '<div><item-row v-for="item in items" :key="item.id" :item="item"/></div>',
        created: function () {
            itemApi.get().then(result =>
                result.json().then(data =>
                    data.forEach(item => this.items.push(item))
                )
            )
        }
    }
)

var app = new Vue({
    el: '#app',
    template: '<item-list :items="items"/>',
    data: {
        items: []
    }
});