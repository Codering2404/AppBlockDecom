package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.ads.zzidy;
import com.google.android.gms.internal.ads.zziee;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zziee<MessageType extends zziee<MessageType, BuilderType>, BuilderType extends zzidy<MessageType, BuilderType>> extends zzicj<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static final Map<Class<?>, zziee<?, ?>> zzd = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzc = -1;
    protected zzigu zzt = zzigu.zza();

    static Method zzbA(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e3) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(name.length() + 43 + String.valueOf(str).length() + 2);
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(str);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    static Object zzbB(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static zziem zzbC() {
        return zzief.zzd();
    }

    protected static zziem zzbD(zziem zziemVar) {
        int size = zziemVar.size();
        return zziemVar.zzh(size + size);
    }

    protected static zziep zzbE() {
        return zzifd.zzg();
    }

    protected static zziep zzbF(zziep zziepVar) {
        int size = zziepVar.size();
        return zziepVar.zzh(size + size);
    }

    protected static zziel zzbG() {
        return zzidv.zzd();
    }

    protected static zziel zzbH(zziel zzielVar) {
        int size = zzielVar.size();
        return zzielVar.zzh(size + size);
    }

    protected static zzieh zzbI() {
        return zzidl.zzd();
    }

    protected static zzieh zzbJ(zzieh zziehVar) {
        int size = zziehVar.size();
        return zziehVar.zzh(size + size);
    }

    protected static zzieg zzbK() {
        return zzicq.zzd();
    }

    protected static zzieg zzbL(zzieg zziegVar) {
        int size = zziegVar.size();
        return zziegVar.zzh(size + size);
    }

    protected static <E> zzieq<E> zzbM() {
        return zziga.zzd();
    }

    protected static <E> zzieq<E> zzbN(zzieq<E> zzieqVar) {
        int size = zzieqVar.size();
        return zzieqVar.zzh(size + size);
    }

    static <T extends zziee<T, ?>> T zzbO(T t2, zzide zzideVar, zzido zzidoVar) throws zziet {
        T t3 = (T) t2.zzbg();
        try {
            zzigh zzighVarZzb = zzifz.zza().zzb(t3.getClass());
            zzighVarZzb.zzg(t3, zzidf.zza(zzideVar), zzidoVar);
            zzighVarZzb.zzk(t3);
            return t3;
        } catch (zziet e3) {
            if (e3.zzb()) {
                throw new zziet(e3);
            }
            throw e3;
        } catch (zzigs e4) {
            throw e4.zza();
        } catch (IOException e5) {
            if (e5.getCause() instanceof zziet) {
                throw ((zziet) e5.getCause());
            }
            throw new zziet(e5);
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zziet) {
                throw ((zziet) e6.getCause());
            }
            throw e6;
        }
    }

    protected static <T extends zziee<T, ?>> T zzbP(T t2, zzide zzideVar) throws zziet {
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
        return (T) zzbO(t2, zzideVar, zzido.zza);
    }

    protected static <T extends zziee<T, ?>> T zzbQ(T t2, ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
        zzide zzideVarZzI;
        int i3 = zzide.zze;
        if (byteBuffer.hasArray()) {
            zzideVarZzI = zzide.zzI(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), false);
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            zzideVarZzI = zzide.zzI(bArr, 0, iRemaining, true);
        }
        T t3 = (T) zzbZ(t2, zzideVarZzI, zzidoVar);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzbR(T t2, ByteBuffer byteBuffer) throws zziet {
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
        return (T) zzbQ(t2, byteBuffer, zzido.zza);
    }

    protected static <T extends zziee<T, ?>> T zzbS(T t2, zzida zzidaVar) throws zziet {
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
        T t3 = (T) zzbT(t2, zzidaVar, zzido.zza);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzbT(T t2, zzida zzidaVar, zzido zzidoVar) throws zziet {
        T t3 = (T) zzj(t2, zzidaVar, zzidoVar);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzbU(T t2, byte[] bArr) throws zziet {
        int length = bArr.length;
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
        T t3 = (T) zzh(t2, bArr, 0, length, zzido.zza);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzbV(T t2, byte[] bArr, zzido zzidoVar) throws zziet {
        T t3 = (T) zzh(t2, bArr, 0, bArr.length, zzidoVar);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzbW(T t2, InputStream inputStream) throws zziet {
        zzide zzideVarZzH = zzide.zzH(inputStream, 4096);
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
        T t3 = (T) zzbO(t2, zzideVarZzH, zzido.zza);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzbX(T t2, InputStream inputStream, zzido zzidoVar) throws zziet {
        T t3 = (T) zzbO(t2, zzide.zzH(inputStream, 4096), zzidoVar);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzbY(T t2, zzide zzideVar) throws zziet {
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
        return (T) zzbZ(t2, zzideVar, zzido.zza);
    }

    protected static <T extends zziee<T, ?>> T zzbZ(T t2, zzide zzideVar, zzido zzidoVar) throws zziet {
        T t3 = (T) zzbO(t2, zzideVar, zzidoVar);
        zzi(t3);
        return t3;
    }

    static <T extends zziee> T zzbt(Class<T> cls) {
        Map<Class<?>, zziee<?, ?>> map = zzd;
        zziee<?, ?> zzieeVar = map.get(cls);
        if (zzieeVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzieeVar = map.get(cls);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException("Class initialization cannot fail.", e3);
            }
        }
        if (zzieeVar != null) {
            return zzieeVar;
        }
        zziee<?, ?> zzieeVarZzbw = ((zziee) zziha.zzb(cls)).zzbw();
        if (zzieeVarZzbw == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzieeVarZzbw);
        return zzieeVarZzbw;
    }

    protected static <T extends zziee> void zzbu(Class<T> cls, T t2) {
        t2.zzaY();
        zzd.put(cls, t2);
    }

    protected static Object zzbv(zzifp zzifpVar, String str, Object[] objArr) {
        return new zzigb(zzifpVar, str, objArr);
    }

    public static <ContainingType extends zzifp, Type> zziec<ContainingType, Type> zzby(ContainingType containingtype, Type type, zzifp zzifpVar, zziej zziejVar, int i3, zzihg zzihgVar, Class cls) {
        return new zziec<>(containingtype, type, zzifpVar, new zzieb(zziejVar, i3, zzihgVar, false, false), cls);
    }

    public static <ContainingType extends zzifp, Type> zziec<ContainingType, Type> zzbz(ContainingType containingtype, zzifp zzifpVar, zziej zziejVar, int i3, zzihg zzihgVar, boolean z2, Class cls) {
        return new zziec<>(containingtype, zziga.zzd(), zzifpVar, new zzieb(zziejVar, i3, zzihgVar, true, z2), cls);
    }

    private void zzc() {
        if (this.zzt == zzigu.zza()) {
            this.zzt = zzigu.zzb();
        }
    }

    protected static <T extends zziee<T, ?>> T zzca(T t2, InputStream inputStream) throws zziet {
        int i3 = zzido.zzb;
        int i4 = zzicn.zza;
        T t3 = (T) zzk(t2, inputStream, zzido.zza);
        zzi(t3);
        return t3;
    }

    protected static <T extends zziee<T, ?>> T zzcb(T t2, InputStream inputStream, zzido zzidoVar) throws zziet {
        T t3 = (T) zzk(t2, inputStream, zzidoVar);
        zzi(t3);
        return t3;
    }

    private int zzd(zzigh<?> zzighVar) {
        if (zzighVar != null) {
            return zzighVar.zze(this);
        }
        return zzifz.zza().zzb(getClass()).zze(this);
    }

    private static <MessageType extends zziea<MessageType, BuilderType>, BuilderType, T> zziec<MessageType, T> zze(zzidm<MessageType, T> zzidmVar) {
        return (zziec) zzidmVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends zziee<T, ?>> boolean zzg(T t2, boolean z2) {
        byte bByteValue = ((Byte) t2.zzdc(zzied.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzifz.zza().zzb(t2.getClass()).zzl(t2);
        if (z2) {
            t2.zzdc(zzied.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t2, null);
        }
        return zZzl;
    }

    private static <T extends zziee<T, ?>> T zzh(T t2, byte[] bArr, int i3, int i4, zzido zzidoVar) throws zziet {
        if (i4 == 0) {
            return t2;
        }
        T t3 = (T) t2.zzbg();
        try {
            zzigh zzighVarZzb = zzifz.zza().zzb(t3.getClass());
            zzighVarZzb.zzj(t3, bArr, i3, i3 + i4, new zzico(zzidoVar));
            zzighVarZzb.zzk(t3);
            return t3;
        } catch (zziet e3) {
            if (e3.zzb()) {
                throw new zziet(e3);
            }
            throw e3;
        } catch (zzigs e4) {
            throw e4.zza();
        } catch (IOException e5) {
            if (e5.getCause() instanceof zziet) {
                throw ((zziet) e5.getCause());
            }
            throw new zziet(e5);
        } catch (IndexOutOfBoundsException unused) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static <T extends zziee<T, ?>> T zzi(T t2) throws zziet {
        if (t2 == null || t2.zzbi()) {
            return t2;
        }
        throw t2.zzaU().zza();
    }

    private static <T extends zziee<T, ?>> T zzj(T t2, zzida zzidaVar, zzido zzidoVar) throws zziet {
        zzide zzideVarZzm = zzidaVar.zzm();
        T t3 = (T) zzbO(t2, zzideVarZzm, zzidoVar);
        zzideVarZzm.zzb(0);
        return t3;
    }

    private static <T extends zziee<T, ?>> T zzk(T t2, InputStream inputStream, zzido zzidoVar) throws zziet {
        try {
            int i3 = inputStream.read();
            if (i3 == -1) {
                return null;
            }
            zzide zzideVarZzH = zzide.zzH(new zzich(inputStream, zzide.zzO(i3, inputStream)), 4096);
            T t3 = (T) zzbO(t2, zzideVarZzH, zzidoVar);
            zzideVarZzH.zzb(0);
            return t3;
        } catch (zziet e3) {
            if (e3.zzb()) {
                throw new zziet(e3);
            }
            throw e3;
        } catch (IOException e4) {
            throw new zziet(e4);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzifz.zza().zzb(getClass()).zzb(this, (zziee) obj);
    }

    public int hashCode() {
        if (zzaX()) {
            return zzbh();
        }
        if (zzbc()) {
            zzba(zzbh());
        }
        return zzaZ();
    }

    public String toString() {
        return zzifr.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzicj
    final int zzaQ() {
        return this.zzc & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.ads.zzicj
    void zzaR(int i3) {
        if (i3 >= 0) {
            this.zzc = i3 | (this.zzc & zza);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 42);
        sb.append("serialized size must be non-negative, was ");
        sb.append(i3);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzicj
    int zzaT(zzigh zzighVar) {
        if (!zzaX()) {
            if (zzaQ() != Integer.MAX_VALUE) {
                return zzaQ();
            }
            int iZzd = zzd(zzighVar);
            zzaR(iZzd);
            return iZzd;
        }
        int iZzd2 = zzd(zzighVar);
        if (iZzd2 >= 0) {
            return iZzd2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzd2).length() + 42);
        sb.append("serialized size must be non-negative, was ");
        sb.append(iZzd2);
        throw new IllegalStateException(sb.toString());
    }

    final boolean zzaX() {
        return (this.zzc & zza) != 0;
    }

    final void zzaY() {
        this.zzc &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    final int zzaZ() {
        return this.zzq;
    }

    final void zzba(int i3) {
        this.zzq = i3;
    }

    final void zzbb() {
        this.zzq = 0;
    }

    final boolean zzbc() {
        return zzaZ() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public final zzifx<MessageType> zzbd() {
        return (zzifx) zzdc(zzied.GET_PARSER, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzifq
    /* JADX INFO: renamed from: zzbe, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbw() {
        return (MessageType) zzdc(zzied.GET_DEFAULT_INSTANCE, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    /* JADX INFO: renamed from: zzbf, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcY() {
        return (BuilderType) zzdc(zzied.NEW_BUILDER, null, null);
    }

    final MessageType zzbg() {
        return (MessageType) zzdc(zzied.NEW_MUTABLE_INSTANCE, null, null);
    }

    final int zzbh() {
        return zzifz.zza().zzb(getClass()).zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzifq
    public final boolean zzbi() {
        return zzg(this, true);
    }

    protected final boolean zzbj(int i3, zzide zzideVar) throws IOException {
        if ((i3 & 7) == 4) {
            return false;
        }
        zzc();
        return this.zzt.zzl(i3, zzideVar);
    }

    protected final void zzbk(int i3, int i4) {
        zzc();
        zzigu zziguVar = this.zzt;
        zziguVar.zze();
        if (i3 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zziguVar.zzk(i3 << 3, Long.valueOf(i4));
    }

    protected final void zzbl(int i3, zzida zzidaVar) {
        zzc();
        zzigu zziguVar = this.zzt;
        zziguVar.zze();
        if (i3 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zziguVar.zzk((i3 << 3) | 2, zzidaVar);
    }

    protected final void zzbm() {
        zzifz.zza().zzb(getClass()).zzk(this);
        zzaY();
    }

    protected final <MessageType2 extends zziee<MessageType2, BuilderType2>, BuilderType2 extends zzidy<MessageType2, BuilderType2>> BuilderType2 zzbn() {
        return (BuilderType2) zzdc(zzied.NEW_BUILDER, null, null);
    }

    protected final <MessageType2 extends zziee<MessageType2, BuilderType2>, BuilderType2 extends zzidy<MessageType2, BuilderType2>> BuilderType2 zzbo(MessageType2 messagetype2) {
        BuilderType2 buildertype2 = (BuilderType2) zzbn();
        buildertype2.zzbo(messagetype2);
        return buildertype2;
    }

    /* JADX INFO: renamed from: zzbp, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcc() {
        BuilderType buildertype = (BuilderType) zzdc(zzied.NEW_BUILDER, null, null);
        buildertype.zzbo(this);
        return buildertype;
    }

    final void zzbq() {
        zzaR(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public int zzbr() {
        return zzaT(null);
    }

    final Object zzbs() throws Exception {
        return zzdc(zzied.BUILD_MESSAGE_INFO, null, null);
    }

    protected final void zzbx(zzigu zziguVar) {
        this.zzt = zzigu.zzc(this.zzt, zziguVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public void zzcX(zzidj zzidjVar) throws IOException {
        zzifz.zza().zzb(getClass()).zzf(this, zzidk.zza(zzidjVar));
    }

    protected abstract Object zzdc(zzied zziedVar, Object obj, Object obj2);
}
