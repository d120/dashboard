<script>


var timeOnly = function (date) {
    date.setFullYear(2000);
    date.setMonth(0);
    date.setDate(1);

    return date;
};

var INTERVAL_CAFETERIA = {
    from: timeOnly(new Date('01/01/2000 11:00:00')),
    to: timeOnly(new Date('01/01/2000 14:00:00'))
};
var INTERVAL_PIZZA = {
    from: timeOnly(new Date('01/01/2000 16:00:00')),
    to: timeOnly(new Date('01/01/2000 23:00:00'))
};


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
        interval: ${departuresInterval}
    }, {
        name: 'cafeteria',
        interval: ${cafeteriaInterval},
        isActive: function () {
            var date = timeOnly(new Date());
            return date >= INTERVAL_CAFETERIA.from && date <= INTERVAL_CAFETERIA.to;
        }
    }, {
        name: 'pizzaPad',
        interval: ${pizzaInterval},
        isActive: function () {
            var date = timeOnly(new Date());
            return date >= INTERVAL_PIZZA.from && date <= INTERVAL_PIZZA.to
        }
    }]
};


</script>
