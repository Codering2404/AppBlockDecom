package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.firebase-auth-api.zzalf.zzb;
import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzalf<MessageType extends zzalf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajm<MessageType, BuilderType> {
    private static Map<Class<?>, zzalf<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzanx zzb = zzanx.zzc();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class zza<T extends zzalf<T, ?>> extends zzajq<T> {
        public zza(T t2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class zzc implements zzakz<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzaog zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzaoj zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzaml zza(zzaml zzamlVar, zzamm zzammVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakz
        public final zzamr zza(zzamr zzamrVar, zzamr zzamrVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzalf<MessageType, BuilderType> implements zzamo {
        protected zzakx<zzc> zzc = zzakx.zzb();

        final zzakx<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzakx) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class zzf<ContainingType extends zzamm, Type> extends zzakr<ContainingType, Type> {
    }

    static /* synthetic */ boolean zza(zzalf zzalfVar, boolean z2) {
        return zzb(zzalfVar, false);
    }

    private final int zzb(zzanb<?> zzanbVar) {
        return zzanbVar == null ? zzamx.zza().zza(this).zza(this) : zzanbVar.zza(this);
    }

    protected static <E> zzalm<E> zzp() {
        return zzana.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzamx.zza().zza(this).zzb(this, (zzalf) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzw()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public String toString() {
        return zzamn.zza(this, super.toString());
    }

    protected abstract Object zza(int i3, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
    final int zzi() {
        return this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final int zzl() {
        return zza((zzanb) null);
    }

    protected final <MessageType2 extends zzalf<MessageType2, BuilderType2>, BuilderType2 extends zzb<MessageType2, BuilderType2>> BuilderType2 zzm() {
        return (BuilderType2) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return (BuilderType) ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    final MessageType zzo() {
        return (MessageType) zza(zze.zzd, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final /* synthetic */ zzaml zzq() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final /* synthetic */ zzaml zzr() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
    public final /* synthetic */ zzamm zzs() {
        return (zzalf) zza(zze.zzf, (Object) null, (Object) null);
    }

    protected final void zzt() {
        zzamx.zza().zza(this).zzd(this);
        zzu();
    }

    final void zzu() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
    public final boolean zzv() {
        return zzb(this, true);
    }

    final boolean zzw() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    private final int zza() {
        return zzamx.zza().zza(this).zzb(this);
    }

    private static <T extends zzalf<T, ?>> T zzb(T t2, zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        zzakh zzakhVarZzc = zzajvVar.zzc();
        T t3 = (T) zza(t2, zzakhVarZzc, zzakuVar);
        zzakhVarZzc.zzc(0);
        return t3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
    final int zza(zzanb zzanbVar) {
        if (zzw()) {
            int iZzb = zzb((zzanb<?>) zzanbVar);
            if (iZzb >= 0) {
                return iZzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
        }
        if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        }
        int iZzb2 = zzb((zzanb<?>) zzanbVar);
        zzb(iZzb2);
        return iZzb2;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class zzb<MessageType extends zzalf<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzajo<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        protected zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzw()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzo();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzb.zza(zze.zze, null, null);
            zzbVar.zza = (MessageType) zzf();
            return zzbVar;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzw()) {
                zzh();
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajo
        /* JADX INFO: renamed from: zzb */
        public final /* synthetic */ zzajo clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaml
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final MessageType zze() {
            MessageType messagetype = (MessageType) zzf();
            if (messagetype.zzv()) {
                return messagetype;
            }
            throw new zzanv(messagetype);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaml
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public MessageType zzf() {
            if (!this.zza.zzw()) {
                return this.zza;
            }
            this.zza.zzt();
            return this.zza;
        }

        protected final void zzg() {
            if (this.zza.zzw()) {
                return;
            }
            zzh();
        }

        protected void zzh() {
            MessageType messagetype = (MessageType) this.zzb.zzo();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
        public final /* synthetic */ zzamm zzs() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamo
        public final boolean zzv() {
            return zzalf.zza((zzalf) this.zza, false);
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzamx.zza().zza(messagetype).zza(messagetype, messagetype2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajm
    final void zzb(int i3) {
        if (i3 >= 0) {
            this.zzd = (i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i3);
        }
    }

    private static final <T extends zzalf<T, ?>> boolean zzb(T t2, boolean z2) {
        byte bByteValue = ((Byte) t2.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZze = zzamx.zza().zza(t2).zze(t2);
        if (z2) {
            t2.zza(zze.zzb, zZze ? t2 : null, null);
        }
        return zZze;
    }

    private static <T extends zzalf<T, ?>> T zza(T t2) throws zzall {
        if (t2 == null || zzb(t2, true)) {
            return t2;
        }
        zzall zzallVarZza = new zzanv(t2).zza();
        zzallVarZza.getClass();
        throw zzallVarZza;
    }

    static <T extends zzalf<?, ?>> T zza(Class<T> cls) {
        T t2 = (T) zzc.get(cls);
        if (t2 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t2 = (T) zzc.get(cls);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException("Class initialization cannot fail.", e3);
            }
        }
        if (t2 != null) {
            return t2;
        }
        T t3 = (T) ((zzalf) zzanz.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
        if (t3 != null) {
            zzc.put((Class<?>) cls, t3);
            return t3;
        }
        throw new IllegalStateException();
    }

    protected static <T extends zzalf<T, ?>> T zza(T t2, zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (T) zza(zzb(t2, zzajvVar, zzakuVar));
    }

    protected static <T extends zzalf<T, ?>> T zza(T t2, InputStream inputStream, zzaku zzakuVar) throws zzall {
        zzakh zzakjVar;
        if (inputStream == null) {
            byte[] bArr = zzalh.zzb;
            zzakjVar = zzakh.zza(bArr, 0, bArr.length, false);
        } else {
            zzakjVar = new zzakj(inputStream);
        }
        return (T) zza(zza(t2, zzakjVar, zzakuVar));
    }

    protected static <T extends zzalf<T, ?>> T zza(T t2, byte[] bArr, zzaku zzakuVar) throws zzall {
        return (T) zza(zza(t2, bArr, 0, bArr.length, zzakuVar));
    }

    private static <T extends zzalf<T, ?>> T zza(T t2, zzakh zzakhVar, zzaku zzakuVar) throws zzall {
        T t3 = (T) t2.zzo();
        try {
            zzanb zzanbVarZza = zzamx.zza().zza(t3);
            zzanbVarZza.zza(t3, zzakl.zza(zzakhVar), zzakuVar);
            zzanbVarZza.zzd(t3);
            return t3;
        } catch (zzall e3) {
            if (e3.zzl()) {
                throw new zzall(e3);
            }
            throw e3;
        } catch (zzanv e4) {
            zzall zzallVarZza = e4.zza();
            zzallVarZza.getClass();
            throw zzallVarZza;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzall) {
                throw ((zzall) e5.getCause());
            }
            throw new zzall(e5);
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zzall) {
                throw ((zzall) e6.getCause());
            }
            throw e6;
        }
    }

    private static <T extends zzalf<T, ?>> T zza(T t2, byte[] bArr, int i3, int i4, zzaku zzakuVar) throws zzall {
        if (i4 == 0) {
            return t2;
        }
        T t3 = (T) t2.zzo();
        try {
            zzanb zzanbVarZza = zzamx.zza().zza(t3);
            zzanbVarZza.zza(t3, bArr, 0, i4, new zzaju(zzakuVar));
            zzanbVarZza.zzd(t3);
            return t3;
        } catch (zzall e3) {
            if (e3.zzl()) {
                throw new zzall(e3);
            }
            throw e3;
        } catch (zzanv e4) {
            zzall zzallVarZza = e4.zza();
            zzallVarZza.getClass();
            throw zzallVarZza;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzall) {
                throw ((zzall) e5.getCause());
            }
            throw new zzall(e5);
        } catch (IndexOutOfBoundsException unused) {
            zzall zzallVarZzj = zzall.zzj();
            zzallVarZzj.getClass();
            throw zzallVarZzj;
        }
    }

    protected static <E> zzalm<E> zza(zzalm<E> zzalmVar) {
        return zzalmVar.zza(zzalmVar.size() << 1);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static Object zza(zzamm zzammVar, String str, Object[] objArr) {
        return new zzamz(zzammVar, str, objArr);
    }

    protected static <T extends zzalf<?, ?>> void zza(Class<T> cls, T t2) {
        t2.zzu();
        zzc.put(cls, t2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final void zza(zzakn zzaknVar) throws IOException {
        zzamx.zza().zza(this).zza(this, zzakp.zza(zzaknVar));
    }
}
