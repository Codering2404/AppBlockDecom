package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ConnectorAggregation implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract ConnectorAggregation a();

        public abstract Builder b(Instant instant);

        public abstract Builder c(Integer num);

        public abstract Builder d(Integer num);

        public abstract Builder e(Double d3);

        public abstract Builder f(Integer num);
    }

    public static Builder a(EVConnectorType eVConnectorType, Double d3, Integer num) {
        zzo zzoVar = new zzo();
        zzoVar.g(eVConnectorType);
        zzoVar.e(d3);
        zzoVar.d(num);
        return zzoVar;
    }

    public abstract Instant c();

    public abstract Integer d();

    public abstract Integer e();

    public abstract Double f();

    public abstract Integer g();

    public abstract EVConnectorType h();
}
