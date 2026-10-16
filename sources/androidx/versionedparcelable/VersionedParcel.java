package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.glance.session.ecY.lisODU;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class VersionedParcel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ArrayMap f53712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final ArrayMap f53713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final ArrayMap f53714c;

    /* JADX INFO: renamed from: androidx.versionedparcelable.VersionedParcel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    class AnonymousClass1 extends ObjectInputStream {
        @Override // java.io.ObjectInputStream
        protected Class resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        this.f53712a = arrayMap;
        this.f53713b = arrayMap2;
        this.f53714c = arrayMap3;
    }

    private void N(VersionedParcelable versionedParcelable) {
        try {
            I(c(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e3);
        }
    }

    private Class c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f53714c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f53714c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws NoSuchMethodException {
        Method method = (Method) this.f53712a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.f53712a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f53713b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f53713b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i3) {
        w(i3);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i3) {
        w(i3);
        C(charSequence);
    }

    protected abstract void E(int i3);

    public void F(int i3, int i4) {
        w(i4);
        E(i3);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i3) {
        w(i3);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i3) {
        w(i3);
        I(str);
    }

    protected void L(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            I(null);
            return;
        }
        N(versionedParcelable);
        VersionedParcel versionedParcelB = b();
        K(versionedParcelable, versionedParcelB);
        versionedParcelB.a();
    }

    public void M(VersionedParcelable versionedParcelable, int i3) {
        w(i3);
        L(versionedParcelable);
    }

    protected abstract void a();

    protected abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z2, int i3) {
        return !m(i3) ? z2 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i3) {
        return !m(i3) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i3) {
        return !m(i3) ? charSequence : k();
    }

    protected abstract boolean m(int i3);

    protected VersionedParcelable n(String str, VersionedParcel versionedParcel) {
        try {
            return (VersionedParcelable) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    protected abstract int o();

    public int p(int i3, int i4) {
        return !m(i4) ? i3 : o();
    }

    protected abstract Parcelable q();

    public Parcelable r(Parcelable parcelable, int i3) {
        return !m(i3) ? parcelable : q();
    }

    protected abstract String s();

    public String t(String str, int i3) {
        return !m(i3) ? str : s();
    }

    protected VersionedParcelable u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return n(strS, b());
    }

    public VersionedParcelable v(VersionedParcelable versionedParcelable, int i3) {
        return !m(i3) ? versionedParcelable : u();
    }

    protected abstract void w(int i3);

    public void x(boolean z2, boolean z3) {
    }

    protected abstract void y(boolean z2);

    public void z(boolean z2, int i3) {
        w(i3);
        y(z2);
    }

    protected void K(VersionedParcelable versionedParcelable, VersionedParcel versionedParcel) {
        try {
            e(versionedParcelable.getClass()).invoke(null, versionedParcelable, versionedParcel);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(lisODU.KHcOScaKgpk, e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }
}
