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
        link: {
            type: String,
            default: '#', // Default to "#" if no link is provided
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
        textParts() {
            // Split the text around "Klik her" to create clickable parts
            const textParts = this.text.split("Klik her");
            return {
                before: textParts[0], // Text before "Klik her"
                clickable: "Klik her", // The clickable part
                after: textParts[1] || '', // Text after "Klik her"
            };
        }
    },
    methods: {
        handleClick() {
            if (this.link && this.link !== '#') {
                window.location.href = this.link; // Redirect to the link
            } else {
                console.log("No valid link specified.");
            }
        }
    },
    template: `
    <div :class="computedClasses">
        <span>{{ textParts.before }}</span>
        <a href="#" @click.prevent="handleClick" style="text-decoration: underline; cursor: pointer;">
            {{ textParts.clickable }}
        </a>
        <span>{{ textParts.after }}</span>
    </div>
    `,
};
