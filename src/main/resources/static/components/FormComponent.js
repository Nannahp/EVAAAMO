export default {
    name: 'FormComponent',
    props: {
        title: {
            type: String,
            required: true,
        },
        formWidth: {
            type: String,
            default: 'w-48 md:w-64 lg:w-82',
        },
        action: {
            type: String,
            default: '',
        },
        method: {
            type: String,
            default: 'post',
        },
    },
    computed: {
        computedWidth() {
            return this.formWidth;
        },
    },
    methods: {
        handleSubmit(event) {
            event.preventDefault(); // Prevent default form submission.
            this.$el.querySelector('form').submit(); // Manually submit the form.
        },
    },
    template: `
    <div class="flex flex-col items-center justify-center min-h-screen">
      <div :class="'p-8 shadow-md ' + computedWidth" style="background-color: rgba(0, 0, 0, 0.8);">
        <h1 class="text-[#EAEAEA] text-2xl font-bold text-center mb-6">{{ title }}</h1>
        <form :action="action" :method="method" @submit="handleSubmit">
          <slot></slot>
        </form>
      </div>
    </div>
  `,
};
