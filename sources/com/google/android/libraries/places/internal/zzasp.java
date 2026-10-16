package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzasp {
    public static zzbiy a(final zzcez zzcezVar) {
        return new zzaso(new zzcez() { // from class: com.google.android.libraries.places.internal.zzasn
            @Override // com.google.android.libraries.places.internal.zzcez
            public final /* synthetic */ Object zzb() {
                return ImmutableList.z(((zzff) zzcezVar).zzb());
            }
        }, 2, zzbex.class, zzbex.class);
    }

    static /* synthetic */ void b(zzbml zzbmlVar, Class cls, boolean z2) throws zzbnq {
        Class clsZzc;
        boolean z3;
        try {
            clsZzc = ((zzbmk) (z2 ? zzbmlVar.f() : zzbmlVar.g())).zzc();
            z3 = false;
        } catch (ClassCastException unused) {
            clsZzc = Object.class;
            z3 = true;
        }
        if (cls.isAssignableFrom(clsZzc)) {
            return;
        }
        String str = true != z2 ? "response" : "request";
        zzbnp zzbnpVar = zzbnp.f76495l;
        String strB = zzbmlVar.b();
        String name = clsZzc.getName();
        String str2 = true != z3 ? "" : ", assumed because method doesn't use ReflectableMarshaller";
        String string = cls.toString();
        StringBuilder sb = new StringBuilder(str.length() + 52 + String.valueOf(strB).length() + 2 + name.length() + str2.length() + 24 + string.length());
        sb.append("AsyncClientInterceptor: The ");
        sb.append(str);
        sb.append(" message type of method ");
        sb.append(strB);
        sb.append(" (");
        sb.append(name);
        sb.append(str2);
        sb.append(") must be a subclass of ");
        sb.append(string);
        throw new zzbnq(zzbnpVar.e(sb.toString()), null);
    }
}
