export default {
    props: ['eventId'],
    data() {
        return {
            event: {
                mediaUrls: [] // Initialize mediaUrls as an empty array
            },
        };
    },
    watch: {
        eventId(newId) {
            this.fetchEvent(newId);
        },
    },
    methods: {
        isYoutubeLink(url) {
            return typeof url === 'string' && (url.includes('youtube.com') || url.includes('youtu.be'));
        },
        getYoutubeEmbedUrl(url) {
            const videoId = url.match(/(?:v=|\/)([a-zA-Z0-9_-]{11})/);
            return videoId ? `https://www.youtube.com/embed/${videoId[1]}` : '';
        },
        fetchEvent(eventId) {
            axios.get(`/api/event?eventId=${eventId}`)
                .then(response => {
                    this.event = response.data;
                })
                .catch(error => {
                    console.error('Error fetching the event:', error);
                });
        },
    },
    mounted() {
        this.fetchEvent(this.eventId); // Fetch the event when the component is mounted
    },
    template: `
        <div class="flex flex-col sm:flex-row items-center sm:items-start gap-6">
            <p>{{ event.title }}</p>
            <p>{{ event.startDate }}</p>
            <p>{{ event.endDate }}</p>
            <p>{{ event.description }}</p>
          
            <ul>
                <li v-for="media in event.mediaUrls" :key="media.mediaId">
        <template v-if="isYoutubeLink(media.mediaUrl)">
            <iframe 
                :src="getYoutubeEmbedUrl(media.mediaUrl)" 
                class="video-embed">
            </iframe>
        </template>
        <template v-else>
            <img   class="w-48 md:w-64 lg:w-82 "  :src="media.mediaUrl" alt="Event picture">
        </template>
    </li>
            </ul>
        </div>
    `,
};
