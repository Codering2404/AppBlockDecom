package ru.noties.markwon;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Prop<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f147090a;

    Prop(String str) {
        this.f147090a = str;
    }

    public static Prop c(String str) {
        return new Prop(str);
    }

    public Object a(RenderProps renderProps) {
        return renderProps.c(this);
    }

    public Object b(RenderProps renderProps, Object obj) {
        return renderProps.a(this, obj);
    }

    public Object d(RenderProps renderProps) {
        Object objA = a(renderProps);
        if (objA != null) {
            return objA;
        }
        throw new NullPointerException(this.f147090a);
    }

    public void e(RenderProps renderProps, Object obj) {
        renderProps.d(this, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f147090a.equals(((Prop) obj).f147090a);
    }

    public int hashCode() {
        return this.f147090a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.f147090a + "'}";
    }
}
