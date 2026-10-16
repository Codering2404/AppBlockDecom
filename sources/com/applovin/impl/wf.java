package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.exoplayer2.common.base.Supplier;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class wf {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a extends e {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient Supplier f64662g;

        a(Map map, Supplier supplier) {
            super(map);
            this.f64662g = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.applovin.impl.h
        Map b() {
            return h();
        }

        @Override // com.applovin.impl.h
        Set c() {
            return i();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.applovin.impl.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public List g() {
            return (List) this.f64662g.get();
        }
    }

    static boolean a(tf tfVar, Object obj) {
        if (obj == tfVar) {
            return true;
        }
        if (obj instanceof tf) {
            return tfVar.a().equals(((tf) obj).a());
        }
        return false;
    }

    public static ec a(Map map, Supplier supplier) {
        return new a(map, supplier);
    }
}
