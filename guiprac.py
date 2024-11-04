import tkinter
from tkinter import *
from tkinter import messagebox

root=Tk()
root.configure()
root.title("Student Form")
root.minsize(620,360)
root.geometry('620x410')
frametitle=Frame(root)
frametitle.pack(fill="x")
frametitle.configure(bg="lightblue")
p=Label(frametitle,text="STUDENTS REGISTRATION FORM",bg="lightblue",font=("Verdana", 16, "bold"))
p.pack()
Label(root,text="").pack()


def clicked():
    name = e1.get()
    selected_class=""
    if v.get() == 1:
        selected_class="F.E."
    elif v.get()==2:
        selected_class="S.E."
    elif v.get()==3:
        selected_class="T.E."
    elif v.get()==4:
        selected_class="B.E."
    else:
        selected_class="None"
        
    selected_class2=""
    if w.get() == 1:
        selected_class2="HCI"
    elif w.get()==2:
        selected_class2="CN"
    elif w.get()==3:
        selected_class2="DBMS"
    elif w.get()==4:
        selected_class2="SPOS"
    else:
        selected_class2="None"
        
    text='Hello '+ name + '. You have opted for ' + def_val.get() + ' branch for class ' + selected_class + ' and subject ' + selected_class2
    messagebox.showinfo('REGISTRATION SUCCESSFUL!',text)
    

def cancelled():
    messagebox.showinfo('Thank you!','The session is about to end')
    root.quit()


frame1=Frame(root)
frame1.pack()

Label(frame1,text="Name",font=("bold",14)).grid(row=0,column=0,sticky=W,padx=(20,0))


Label(frame1,text="Middle Name",font=("bold",14)).grid(row=0,column=1,padx=(90,0))
Label(frame1,text="Surname",font=("bold",14)).grid(row=0,column=2,padx=(28,0))
e1=Entry(frame1,bg="lightblue")
e2=Entry(frame1,bg="lightblue")
e3=Entry(frame1,bg="lightblue")
e1.grid(row=1,column=0,sticky=W,padx=(20,0))
e2.grid(row=1,column=1,padx=(100,0))
e3.grid(row=1,column=2,sticky=E,padx=(80,0))
Label(frame1,text="").grid(row=2,column=0)


def_val = StringVar(root)
options = ["Computer","IT","Mechanical"]
def_val.set("None")
dropdown = OptionMenu(frame1,def_val,*options)
dropdown.configure(bg="lightblue")
dropdown.grid(row=3,column=0,sticky=W,padx=(0,0))

Label(root,text="").pack()

frame2=Frame(root)
frame2.pack()

v = IntVar()
Label(frame2,text="Class:",font=("bold",14)).grid(row=0,column=0,sticky=W,padx=(20,0))
r1=Radiobutton(frame2,text="F.E.",variable=v,value=1,font=(10))
r1.config(relief=tkinter.RAISED)
r1.grid(row=0,column=1,padx=(60,0))

r2=Radiobutton(frame2,text="S.E.",variable=v,value=2,font=(10))
r2.config(relief=tkinter.RAISED)
r2.grid(row=0,column=2,padx=(60,0))

r3=Radiobutton(frame2,text="T.E.",variable=v,value=3,font=(10))
r3.config(relief=tkinter.RAISED)
r3.grid(row=0,column=3,padx=(56,0))

r4=Radiobutton(frame2,text="B.E.",variable=v,value=4,font=(10))
r4.config(relief=tkinter.RAISED)
r4.grid(row=0,column=4,padx=(46,0))

Label(frame2,text="").grid(row=1)

Label(frame2,text="Courses:",font=("bold",14)).grid(row=2,column=0,sticky=W,padx=(20,0))
w=IntVar()
r5 = Radiobutton(frame2, text="HCI", variable=w, value=1, font=(10))
r5.config(relief=tkinter.RAISED)
r5.grid(row=2, column=1, padx=(60, 0))

r6 = Radiobutton(frame2, text="CN", variable=w, value=2, font=(10))
r6.config(relief=tkinter.RAISED)
r6.grid(row=2, column=2, padx=(55, 0))

r7 = Radiobutton(frame2, text="DBMS", variable=w, value=3, font=(10))
r7.config(relief=tkinter.RAISED)
r7.grid(row=2, column=3, padx=(66, 0))

r8 = Radiobutton(frame2, text="SPOS", variable=w, value=4, font=(10))
r8.config(relief=tkinter.RAISED)
r8.grid(row=2, column=4, padx=(56, 0))

Label(frame2,text="").grid(row=3)
Label(frame2,text="").grid(row=4)
Label(frame2,text="").grid(row=5)

frame3 = Frame(root)
frame3.pack()
z=Button(frame3,text="Register",font=(20),bg="lightblue",width=12,command=clicked).grid(row=4,column=0,padx=40,sticky="e")
y=Button(frame3,text="Cancel",font=(20),bg="lightblue",width=12,command=cancelled).grid(row=4,column=1,padx=40,sticky="w")

root.mainloop()