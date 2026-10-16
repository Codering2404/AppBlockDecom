package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f73470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f73471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f73472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f73473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f73474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f73475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f73476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Long f73477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Long f73478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Long f73479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Boolean f73480k;

    zzbc(String str, String str2, long j3, long j4, long j5, long j6, long j7, Long l3, Long l4, Long l5, Boolean bool) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.a(j3 >= 0);
        Preconditions.a(j4 >= 0);
        Preconditions.a(j5 >= 0);
        Preconditions.a(j7 >= 0);
        this.f73470a = str;
        this.f73471b = str2;
        this.f73472c = j3;
        this.f73473d = j4;
        this.f73474e = j5;
        this.f73475f = j6;
        this.f73476g = j7;
        this.f73477h = l3;
        this.f73478i = l4;
        this.f73479j = l5;
        this.f73480k = bool;
    }

    final zzbc a(long j3) {
        return new zzbc(this.f73470a, this.f73471b, this.f73472c, this.f73473d, this.f73474e, j3, this.f73476g, this.f73477h, this.f73478i, this.f73479j, this.f73480k);
    }

    final zzbc b(long j3, long j4) {
        return new zzbc(this.f73470a, this.f73471b, this.f73472c, this.f73473d, this.f73474e, this.f73475f, j3, Long.valueOf(j4), this.f73478i, this.f73479j, this.f73480k);
    }

    final zzbc c(Long l3, Long l4, Boolean bool) {
        return new zzbc(this.f73470a, this.f73471b, this.f73472c, this.f73473d, this.f73474e, this.f73475f, this.f73476g, this.f73477h, l3, l4, bool);
    }
}
