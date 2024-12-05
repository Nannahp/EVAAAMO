export default {
    name: 'FormButtonComponent',
    props: {
        type: {
            type: String,
            default: 'submit',
        },
    },
    template: `
    <button
      :type="type"
      class="w-full p-3 bg-black bg-opacity-50 text-[#EAEAEA] hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-400"
    >
      <slot></slot>
    </button>
  `,
};
