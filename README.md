# 📋 Lista de Tarefas App

Este é um aplicativo Android nativo desenvolvido em Kotlin que permite ao usuário adicionar, listar e remover tarefas de forma simples e prática.

---

## ✨ Funcionalidades

- ✅ Adicionar novas tarefas
- 🗂️ Visualizar a lista de tarefas
- ❌ Remover tarefas concluídas
- 🖋️ Editar tarefas (se implementado)
- 💾 Salvamento local usando Room
  
---

## 🛠️ Tecnologias e Bibliotecas

- Kotlin
- MVVM (Model-View-ViewModel)
- Room (persistência de dados local)
- LiveData
- RecyclerView
- ViewBinding
- Material Design
  
---

## 📱 Preview 

<img src="https://github.com/user-attachments/assets/ee043e62-d53a-45c5-b1a6-4169f62094f2" width="230">
&nbsp;&nbsp;

<img src="https://github.com/user-attachments/assets/cf04825a-5fe4-4bc7-9743-32d724b2fe38" width="230">
&nbsp;&nbsp;

---

## 📂 Estrutura do Projeto


```plaintext
📁 data
┣ 📄 TaskDao.kt
┗ 📄 TaskDatabase.kt

📁 model
┗ 📄 Task.kt

📁 ui
┣ 📄 MainActivity.kt
┗ 📄 TaskAdapter.kt

📁 viewmodel
┗ 📄 TaskViewModel.kt

📄 activity_main.xml
📄 item_task.xml
```

---

## 📜 Licença

```
The MIT License (MIT)

Copyright (c) 2025 Anderson Pereira dos Santos

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

