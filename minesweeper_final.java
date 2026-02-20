import java.io.*;
class minesweeper_final
{
public static void main(String ar[])throws Exception
{
DataInputStream ob=new DataInputStream(System.in);
int r, c, frame[][], game[][], i, y, choice, m, n, x, ll, score=0, rr=0, cc=0, f=0, rrr, ccc, fc=0, fw=0, dc=0, dw=0, randomr=0, randomc=0, bn, placed=0;

System.out.println("\t\t\tWELCOME TO MINESWEEPER(early access)\n \t\t\t\t made by Sparsh Panjwani");
System.out.println("What Size do You want of the Game?");
System.out.print("No. of rows-");
rr=Integer.parseInt(ob.readLine());
System.out.print("No. of columns-");
cc=Integer.parseInt(ob.readLine());
frame=new int[rr][cc];
game=new int[rr][cc];
System.out.println("Enter the Number of Bombs You want to be in the Game");
bn=Integer.parseInt(ob.readLine());

while(placed<bn)
{
randomr=(int)(Math.random()*rr);
randomc=(int)(Math.random()*cc);
if(frame[randomr][randomc]<10)
{
frame[randomr][randomc]=10;
placed++;
}
}

for(m=0;m<rr;m++)
for(n=0;n<cc;n++)
{
if(frame[m][n]>=10)
{
for(x=m-1;x<=m+1;x++)
for(y=n-1;y<=n+1;y++)
{
if(x>-1&&x<rr&&y>-1&&y<cc)
frame[x][y]+=1;
if(x==m&&y==n)
frame[x][y]--;
}
}
}

a:for(ll=0;ll<=rr*cc;ll++)
{
for(m=0;m<rr;m++)
{
for(n=0;n<cc;n++)
{
if(game[m][n]==20||game[m][n]==63||game[m][n]==32)
System.out.print("| "+(char)(game[m][n])+" | ");
else
System.out.print("| "+game[m][n]+" | ");
}
System.out.println();
for(i=0;i<cc+1;i++)
System.out.print("-----");
System.out.println();
}
System.out.println("Select a cell");
System.out.println("Enter row and column of the cell");
r=Integer.parseInt(ob.readLine());
c=Integer.parseInt(ob.readLine());

while(r>rr||r<1||c>cc||c<1)
{
for(m=0;m<rr;m++)
{
for(n=0;n<cc;n++)
{
if(game[m][n]==25||game[m][n]==63||game[m][n]==32)
System.out.print("| "+(char)(game[m][n])+" | ");
else
System.out.print("| "+game[m][n]+" | ");
}
System.out.println();
for(i=0;i<cc+1;i++)
System.out.print("-----");
System.out.println();
}
System.out.println("Select a cell");
System.out.println("Enter row and column of the cell");
r=Integer.parseInt(ob.readLine());
c=Integer.parseInt(ob.readLine());
}
rrr=r-1;
ccc=c-1;

r--;
c--;
System.out.println("What do you want to do on this cell? \n 1)Play \n 2)Flag \n 3)Doubt");
choice=Integer.parseInt(ob.readLine());

if(choice==1)
{
if(frame[r][c]>=10)
{
System.out.println("GAME OVER!!! \n BOMB BLAST!!!\n Your Score = "+score);
break a;
}
else
game[r][c]=frame[r][c];
if(game[r][c]==0)
game[r][c]=32;
}

if(choice==2)
{
game[r][c]=20;
if(frame[r][c]>=10)
{
fc+=1;
score+=10;
}
else
{
fw+=1;
score-=5;
}
if(frame[r][c]>=10)
frame[r][c]=1000;
else
frame[r][c]=100;
}

if(choice==3)
{
game[r][c]=63;
if(frame[r][c]>=10)
dc+=1;
else
dw+=1;
if(frame[r][c]>=10)
frame[r][c]=1000;
else
frame[r][c]=100;
}
}

if(ll==rr*cc)
System.out.print("Congrats, You Made it To The End :D \n Your Score is="+score);

System.out.println("Your "+fc+" flags had mine under them whereas "+fw+" did not."+dc+" cells you doubted had mines under them whereas "+dw+" did not.");
System.out.println("\tHere Are Where The Mines Were ---------->");

for(m=0;m<rr;m++)
{
for(n=0;n<cc;n++)
{
if(frame[m][n]>=10)
System.out.print("|  B  | ");
else
{
if(game[m][n]==63||game[m][n]==20)
System.out.print("|  "+(char)(game[m][n])+"  | ");
else
System.out.print("|     | ");
}
}
System.out.println();
for(i=0;i<cc;i++)
System.out.print("-------");
System.out.println();
}
}
}