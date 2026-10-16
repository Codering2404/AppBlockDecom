package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzati;
import com.google.android.gms.internal.ads.zzatj;
import com.google.android.gms.internal.ads.zzauh;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbh extends zzauh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f70280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f70281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzl f70282c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbh(zzbl zzblVar, int i3, String str, zzatj zzatjVar, zzati zzatiVar, byte[] bArr, Map map, com.google.android.gms.ads.internal.util.client.zzl zzlVar) {
        super(i3, str, zzatjVar, zzatiVar);
        this.f70280a = bArr;
        this.f70281b = map;
        this.f70282c = zzlVar;
        Objects.requireNonNull(zzblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzate
    public final Map zzm() {
        Map map = this.f70281b;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    @Override // com.google.android.gms.internal.ads.zzate
    public final byte[] zzn() {
        byte[] bArr = this.f70280a;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzauh, com.google.android.gms.internal.ads.zzate
    protected final /* bridge */ /* synthetic */ void zzs(Object obj) {
        zzs((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzauh
    /* JADX INFO: renamed from: zzz */
    public final void zzs(String str) {
        this.f70282c.e(str);
        super.zzs(str);
    }
}
