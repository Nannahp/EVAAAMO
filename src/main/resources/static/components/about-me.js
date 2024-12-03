export default {
    data() {
        return {
            description: '',
        };
    },
    template: `
    <div class="p-4">
        <h1 class="text-center ">OM MIG</h1>
        
    
        <div class="flex flex-col sm:flex-row items-center sm:items-start gap-6">
            <!-- Image -->
            <img 
                class="w-48 md:w-64 lg:w-82 " 
                src="/assets/3f1257a2-4b5d-490a-8267-b43de3116600.jpg" 
                alt="Eva">
            
            <!-- Description -->
            <p class="text-base sm:text-lg leading-relaxed text-gray-700">
                {{ description }}
            </p>
        </div>
    </div>
    `,
    mounted() {
        axios
            .get('/api/about')
            .then(response => {
                this.description = response.data.description;
            })
            .catch(error => {
                console.error('Error fetching the description:', error);
                this.description = 'Failed to load description.';
            });
    },
};
