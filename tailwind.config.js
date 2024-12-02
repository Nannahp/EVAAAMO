/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.{html,js}", // Adjust for HTML templates
    "./src/**/*.{vue,js,ts,jsx,tsx}" // Vue files
  ],
  theme: {
    extend: {},
  },
  plugins: [],
};
