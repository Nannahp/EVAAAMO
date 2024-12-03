import EventDetails from './event-details.js';

export default {
    components: {
        EventDetails, // Register the EventDetails component
    },
    data() {
        return {
            events: [], // List of events fetched from the API
            selectedEventId: null, // ID of the selected event
        };
    },
    methods: {
        selectEvent(eventId) {
            this.selectedEventId = eventId; // Set the selected event ID
        },
    },
    mounted() {
        // Fetch the list of events from the API
        axios
            .get('/api/events')
            .then((response) => {
                this.events = response.data;
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
                    <!-- Button to select an event -->
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
