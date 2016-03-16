package org.envirocar.algorithm;

import org.envirocar.core.entity.Measurement;
import org.envirocar.obd.events.PropertyKeyEvent;
import org.envirocar.obd.events.Timestamped;

import rx.Observable;

/**
 * TODO JavaDoc
 */
public interface MeasurementProvider {

    Observable.Operator<Measurement, PropertyKeyEvent> getOBDValueConsumer(long samplingRate);

    Observable<Measurement> measurements(long samplingRate);

    void consider(PropertyKeyEvent pke);

    void newPosition(Position pos);

    class Position implements Timestamped {

        private final long timestamp;
        private final double latitude;
        private final double longitude;

        public Position(long timestamp, double latitude, double longitude) {
            this.timestamp = timestamp;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}
