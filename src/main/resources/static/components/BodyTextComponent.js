export default {
    name: 'BodyTextComponent',
    props: {
        text: {
            type: String,
            required: true,
        },
        fontSize: {
            type: String,
            default: 'text-base',
        },
        containerHeight: {
            type: String,
            default: 'h-auto',
        },
        containerWidth: {
            type: String,
            default: 'w-full',
        },
        textAlign: {
            type: String,
            default: 'text-left',
        },
        padding: {
            type: String,
            default: 'p-0',
        },
        fontWeight: {
            type: String,
            default: 'font-normal',
        },
    },
    computed: {
        computedClasses() {
            return [
                this.fontSize,
                this.containerHeight,
                this.containerWidth,
                this.textAlign,
                this.padding,
                this.fontWeight,
            ].join(' ');
        },
    },
    template: `
    <div :class="computedClasses">
        {{ text }}
    </div>
    `,
};
