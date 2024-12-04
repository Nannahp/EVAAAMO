import EventDetails from './EventDetails.js';

export default {
    components: {
        EventDetails,
    },
    data() {
        return {
            events: [],
            selectedEventId: null,
        };
    },
    methods: {
        selectEvent(eventId) {
            this.selectedEventId = eventId;
        },
    },
    mounted() {

        axios
            .get('/api/events')
            .then((response) => {
                this.events = response.data;
                console.log(response.data)
            })
            .catch((error) => {
                console.error('Error fetching events', error);
            });
    },
    template: `
    <div class="events-container">
        <!-- Event List -->
        <div class="event-list">
            <ul>
                <li v-for="event in events" :key="event.eventId">
              
                    <button @click="selectEvent(event.eventId)">
                       {{ event.startDate }}
                    </button>
                </li>
            </ul>
        </div>

        <!-- Event Details -->
        <div v-if="selectedEventId">
            <event-details :eventId="selectedEventId"></event-details>
        </div>
    </div>
    `,
};
