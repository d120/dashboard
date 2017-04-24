'use strict';

window.DASHBOARD = {
    interval: 10,
    station: {
        id: 'Darmstadt Willy-Brandt-Platz',
        time: {
            critical: 3,
            warning: 8
        }
    },
    infos: [{
        name: 'departures',
        isActive: function () {
            return true;
        }
    }, {
        name: 'pizzaPad',
        isActive: function () {
            return true;
        }
    }]
};
