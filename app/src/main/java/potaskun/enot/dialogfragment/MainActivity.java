package potaskun.enot.dialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
implements Datable{

    private List<User> users = new ArrayList(); //соединим UserAdapter и ListView

    ListView userssList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        userssList = findViewById(R.id.usersList);
        // создаем адаптер
        UserAdapter userAdapter = new UserAdapter(this, R.layout.items_list_user, users);
        // устанавливаем адаптер
        userssList.setAdapter(userAdapter);
        // слушатель выбора в списке
        userssList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                // получаем выбранный пункт
                User selectedUser = (User)parent.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedUser.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });


        ListView phoneList = findViewById(R.id.phonesList);
        /**
         * массив значений для списка
         */
        ArrayList<String> phone = new ArrayList<>();
        phone.add("phone1");
        phone.add("phone2");
        phone.add("phone3");
        phone.add("phone4");
        phone.add("phone5");

        /*создаем адаптер в который помещаем наш массив, для каждого элемента масива применяется шаблон по умолчанию*/
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phone);
        /*Назначаем нашему ListView созданый адаптер с значениями*/
        phoneList.setAdapter(adapter);

        System.out.println("adapter: " +adapter);

        /* Вешаем слушателя на нажатия по элементу ListView */
        phoneList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                /*Получаем значение элемента по его номеру в адаптере*/
                String selectedPhone = adapter.getItem(position);
                System.out.println("selectPhone: " + selectedPhone);//for test

                Bundle args = new Bundle();//создаем массив для передачи данных между активити и фрагментом
                args.putString("phone", selectedPhone);//помещаем в нее выбраное значение "key"=>"item"
                args.putString("id", String.valueOf(view.getId())); // отправляем id элемента который вызвал событие.

                CustomDialogFragment dialog = new CustomDialogFragment(); //Создаем новый класс фрагмента
                /*Передаем наш массив с нужными переменными в диалог*/
                dialog.setArguments(args);
                /*Вызываем диалог*/
                dialog.show(getSupportFragmentManager(),"custom");
            }
        });
    }

    /**
     * Срабатывает при нажатии кнопки (У нее заложено событие OnClick))
     * @param view
     */
    public void showDialog(View view) {
        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }

    /**
     * Меняем значение поля текст на выбранное в диалоге
     */
    public void updateTextView(String name){
        TextView textView = findViewById(R.id.textView);
        textView.setText(name);
    }

    public void updateTextList(String id){

    }

    private void setInitialData(){

        users.add(new User ("Vasa Pupkin", "0", "0", "1"));
        users.add(new User ("Pedro Porasha", "0", "0", "1"));
        users.add(new User ("Imperator Pu", "0", "0", "1"));
        users.add(new User ("Nikola Two", "2", "0", "1"));
        users.add(new User ("Cherchel Garry", "3", "0", "1"));
    }
}
