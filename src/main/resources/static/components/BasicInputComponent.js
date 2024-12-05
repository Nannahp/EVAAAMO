export default {
    name: 'BasicInputComponent',
    props: {
        label: {
            type: String,
            required: true,
        },
        value: {
            type: String,
        },
        type: {
            type: String,
            default: 'text',
        },
        placeholder: {
            type: String,
            default: '',
        },
        name: {
            type: String,
            default: '',
        },
    },
    template: `
    <div class="mb-4">
      <label :for="label" class="text-[#EAEAEA] block text-sm font-medium mb-1">{{ label }}</label>
      <input
        :type="type"
        :id="label"
        v-model="value"
        :placeholder="placeholder"
        :name="name"
        class="w-full p-2 border focus:outline-none focus:ring-2 focus:ring-gray-400"
      />
    </div>
  `,
};
