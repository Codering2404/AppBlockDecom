package com.facebook.ads.internal.bench;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.CLASS)
public @interface Benchmark {
    int failAtMillis() default Integer.MAX_VALUE;

    int warnAtMillis() default Integer.MAX_VALUE;
}
