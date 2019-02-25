package potaskun.enot.dialogfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Адаптер для преобразования масива пользователей в ListView
 */
public class UserAdapter extends ArrayAdapter<User>{

    private LayoutInflater inflater;
    private int layout;
    private List<User> userList;
    public UserAdapter(@NonNull Context context, int resource, List<User> userList) {
        super(context, resource, userList);
        this.userList = userList; //набор объектов, которые будут выводиться в ListView
        this.layout = resource;  //ресурс разметки интерфейса, который будет использоваться для создания одного элемента в ListView
        this.inflater = LayoutInflater.from(context); //контекст, в котором используется класс. В его роли кк правило выступает класс Activity
    }

    /**
     * устанавливается отображение элемента списка
     * position: передает позицию элемента внутри адаптера, для которого создается представление
     * convertView: старое представление элемента, которое при наличии используется ListView в целях оптимизации
     * parent: родительский компонент для представления элемента
     */

    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false); //создаем объект View для каждого отдельного элемента в списке
        /*Из созданного объекта View получаем элементы по ID */
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView bal1 = (TextView)view.findViewById(R.id.bal1);
        TextView bal2 = (TextView)view.findViewById(R.id.bal2);
        TextView bal3 = (TextView)view.findViewById(R.id.bal3);
        /*Далее используя параметр position, получаем объект User, для которого создается разметка*/
        User user = userList.get(position);
        /*Затем полученные элементы TextView наполняем из полученного по позиции объекта User*/
        name.setText(user.getName());
        bal1.setText(user.getBal1());
        bal2.setText(user.getBal2());
        bal3.setText(user.getBal3());
        return view;
    }
}
