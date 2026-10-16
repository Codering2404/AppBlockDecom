package com.google.android.gms.auth.blockstore;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface BlockstoreClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task deleteBytes(DeleteBytesRequest deleteBytesRequest);

    Task retrieveBytes(RetrieveBytesRequest retrieveBytesRequest);

    Task storeBytes(StoreBytesData storeBytesData);
}
