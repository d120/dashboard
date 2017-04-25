<script>


window.DASHBOARD = {
    station: {
        id: '${departuresStationName}',
        time: {
            critical: ${departuresStationTravelTimeCritical},
            warning: ${departuresStationTravelTimeWarning}
        }
    },
    news: {
        interval: ${newsSwitchInterval}
    },
    infos: [{
        name: 'departures',
        interval: ${departuresInterval},
        isActive: function () {
            return true;
        }
    }, {
        name: 'cafeteria',
        interval: ${cafeteriaInterval},
        isActive: function () {
            return true;
        }
    }, {
        name: 'pizzaPad',
        interval: ${pizzaInterval},
        isActive: function () {
            return true;
        }
    }]
};


</script>
