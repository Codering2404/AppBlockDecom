package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Encodable
public abstract class BatchedLogRequest {
    public static BatchedLogRequest a(List list) {
        return new AutoValue_BatchedLogRequest(list);
    }

    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().j(AutoBatchedLogRequestEncoder.f69083a).k(true).i();
    }

    public abstract List c();
}
