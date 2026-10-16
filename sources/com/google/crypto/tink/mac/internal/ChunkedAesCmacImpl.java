package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class ChunkedAesCmacImpl implements ChunkedMac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TinkFipsUtil.AlgorithmFipsCompatibility f86381a = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
}
