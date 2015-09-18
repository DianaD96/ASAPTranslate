package imp.translator.diana.lang;

/**
 * Created by Diana on 14/09/2015.
 */

        import android.view.View;
        import android.view.ViewGroup;

public interface IAdapterViewInflater<T>
{
    public View inflate(BaseInflaterAdapter<T> adapter, int pos, View convertView, ViewGroup parent);
}
