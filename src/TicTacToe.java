import java.io.*; // instead of stdio and conio
import java.util.Random;

class TicTacToe
{

    final int HEIGHT = 5;
    final int WIDTH = 6;

    int player1;
    int player2;

    char[][] board =
        {{'1', '|', '2', '|', '3', '\0'},
            {'-', '-', '-', '-', '-', '\0'},
            {'4', '|', '5', '|', '6', '\0'},
            {'-', '-', '-', '-', '-', '\0'},
            {'7', '|', '8', '|', '9', '\0'}};

    CharPointer[] p_board = {addressOf(board, 0, 0), addressOf(board, 0, 2), addressOf(board, 0, 4), addressOf(board, 2, 0), addressOf(board, 2, 2),
        addressOf(board, 2, 4), addressOf(board, 4, 0), addressOf(board, 4, 2), addressOf(board, 4, 4)};

    public static void main(String[] args)
    {
        new TicTacToe().main();
    }

    int main()
    {
        int x = 0;
        char choice;
        int turns = 0;
        int winner = 0;
        char[] player_input = new char[10];
        int values_required = 0;
        srand(time());

        printf("Welcome to Tic Tac Toe.\n");
        printf("You can play against another person or the computer.\n");
        printf("Choose your opponent ('C' for the computer or 'P' for player)\n");
        choice = getchar();
        if (choice != 'C' && choice != 'c')
        {
            for (x = 0; x < HEIGHT; x++)
            {
                printRow(board[x]);
            }

            for (turns = 0; turns < 9 && winner == 0; turns++)
            {
                if (turns % 2 == 0)
                {
                    printf("Player one please choose a space to play in: \n");
                    player1 = getchar();
                    applyplayer1(player1);
                    for (x = 0; x < HEIGHT; x++)
                    {
                        printRow(board[x]);
                    }
                    printf("\n\n");
                    testplayer1win();
                    winner = testplayer1win();
                }
                if (turns % 2 == 1)
                {
                    printf("Player two please choose a space to play in: \n");
                    player2 = getchar();/* converts the input to its ASCII code*/
                    applyplayer2(player2);
                    for (x = 0; x < HEIGHT; x++)
                    {
                        printRow(board[x]);
                    }
                    printf("\n\n");
                    testplayer2win();
                    winner = testplayer2win();
                }
            }
        }
        else
        {
            for (x = 0; x < HEIGHT; x++)
            {
                printRow(board[x]);
            }

            for (turns = 0; turns <= 9 && winner == 0; turns++)
            {
                if (turns == 9)
                {
                    printf("Hung game!");
                    break;
                }
                if (turns % 2 == 0)
                {
                    printf("Player one please choose a space to play in: \n");
                    player1 = getchar();
                    applyplayer1(player1);
                    for (x = 0; x < HEIGHT; x++)
                    {
                        printRow(board[x]);
                    }
                    printf("\n\n");
                    testplayer1win();
                    winner = testplayer1win();
                }
                if (turns % 2 == 1)/* Computer player */
                {
                    printf("Computer player makes a move.\n");
                    computer_move(turns);
                    for (x = 0; x < HEIGHT; x++)
                    {
                        printRow(board[x]);
                    }
                    printf("\n\n");
                    testplayer2win();
                    winner = testplayer2win();
                }
            }
        }
        return 0;
    }

    /*based on the input this function assigns an 'X' for player one or 'O',
    in the similary applyplayer2 function, to the playing board */
    void applyplayer1(int move)
    {
        int alt_move;

        switch (move)
        {
        default:
        {
            printf("Illegal move! Try again and please choose a number between 1 and 9 only.\n");
            printf("Please try another move: \n");
            alt_move = getchar();
            applyplayer1(alt_move);
            break;
        }
        case '1':
        {
            test_move1(p_board[0]);
            p_board[0].set('X');
            break;
        }
        case '2':
        {
            test_move1(p_board[1]);
            p_board[1].set('X');
            break;
        }
        case '3':
        {
            test_move1(p_board[2]);
            p_board[2].set('X');
            break;
        }
        case '4':
        {
            test_move1(p_board[3]);
            p_board[3].set('X');
            break;
        }
        case '5':
        {
            test_move1(p_board[4]);
            p_board[4].set('X');
            break;
        }
        case '6':
        {
            test_move1(p_board[5]);
            p_board[5].set('X');
            break;
        }
        case '7':
        {
            test_move1(p_board[6]);
            p_board[6].set('X');
            break;
        }
        case '8':
        {
            test_move1(p_board[7]);
            p_board[7].set('X');
            break;
        }
        case '9':
        {
            test_move1(p_board[8]);
            p_board[8].set('X');
            break;
        }
        }
    }

    void applyplayer2(int move)
    {
        int alt_move;

        switch (move)
        {
        default:
        {
            printf("Illegal move! Try again and please choose a number between 1 and 9 only.\n");
            printf("Please try another move: ");
            alt_move = getchar();
            applyplayer2(alt_move);
            break;
        }
        case '1':
        {
            test_move2(p_board[0]);
            p_board[0].set('O');
            break;
        }
        case '2':
        {
            test_move2(p_board[1]);
            p_board[1].set('O');
            break;
        }
        case '3':
        {
            test_move2(p_board[2]);
            p_board[2].set('O');
            break;
        }
        case '4':
        {
            test_move2(p_board[3]);
            p_board[3].set('O');
            break;
        }
        case '5':
        {
            test_move2(p_board[4]);
            p_board[4].set('O');
            break;
        }
        case '6':
        {
            test_move2(p_board[5]);
            p_board[5].set('O');
            break;
        }
        case '7':
        {
            test_move2(p_board[6]);
            p_board[6].set('O');
            break;
        }
        case '8':
        {
            test_move2(p_board[7]);
            p_board[7].set('O');
            break;
        }
        case '9':
        {
            test_move2(p_board[8]);
            p_board[8].set('O');
            break;
        }
        }
    }

    /* Tests the players move against those already made to see if the player
    has won. Identical to testplayer2*/
    int testplayer1win()
    {

        if (p_board[0].get() == 'X' && p_board[1].get() == 'X' && p_board[2].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else if (p_board[3].get() == 'X' && p_board[4].get() == 'X' && p_board[5].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else if (p_board[6].get() == 'X' && p_board[7].get() == 'X' && p_board[8].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else if (p_board[0].get() == 'X' && p_board[3].get() == 'X' && p_board[6].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else if (p_board[1].get() == 'X' && p_board[4].get() == 'X' && p_board[7].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else if (p_board[2].get() == 'X' && p_board[5].get() == 'X' && p_board[8].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else if (p_board[0].get() == 'X' && p_board[4].get() == 'X' && p_board[8].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else if (p_board[2].get() == 'X' && p_board[4].get() == 'X' && p_board[6].get() == 'X')
        {
            printf("Player 1 wins!");
            return 1;
        }
        else
        {
            return 0;
        }
    }

    int testplayer2win()
    {

        if (p_board[0].get() == 'O' && p_board[1].get() == 'O' && p_board[2].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else if (p_board[3].get() == 'O' && p_board[4].get() == 'O' && p_board[5].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else if (p_board[6].get() == 'O' && p_board[7].get() == 'O' && p_board[8].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else if (p_board[0].get() == 'O' && p_board[3].get() == 'O' && p_board[6].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else if (p_board[1].get() == 'O' && p_board[4].get() == 'O' && p_board[7].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else if (p_board[2].get() == 'O' && p_board[5].get() == 'O' && p_board[8].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else if (p_board[0].get() == 'O' && p_board[4].get() == 'O' && p_board[8].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else if (p_board[2].get() == 'O' && p_board[4].get() == 'O' && p_board[6].get() == 'O')
        {
            printf("Player 2 wins!");
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /*Tests to see if the move chosen by the player is to a space already
    occupied on the board. Results in an error message if this is true and
    prompts the player to make another move/selection. Identical to test_move2*/
    void test_move1(CharPointer p_board)
    {
        int alt_move;

        if (p_board.get() == 'X' || p_board.get() == 'O')
        {
            printf("Illegal move! Try again.\n");
            printf("Please try another move: ");
            alt_move = getchar();
            applyplayer1(alt_move);
        }
        else
        {
            return;
        }
    }

    void test_move2(CharPointer ptr)
    {
        int alt_move;

        if (ptr.get() == 'X' || ptr.get() == 'O')
        {
            printf("Illegal move! Try again.\n");
            printf("Please try another move: ");
            alt_move = getchar();
            applyplayer2(alt_move);
        }
        else
        {
            return;
        }
    }


    void computer_move(int turns)
    {

        if (turns == 1)
        {
            if (p_board[4].get() == 'X')
            {
                int nextmove;
                for (nextmove = rand() % 9; nextmove == 4; nextmove = rand() % 9)
                    ;
                p_board[nextmove].set('O');
            }
            else
            {
                p_board[4].set('O');
            }
        }
        else
        {
            if (p_board[0].get() == 'O' && p_board[1].get() == 'O' && (p_board[2].get() != 'X' && p_board[2].get() != 'O'))
                p_board[2].set('O');
            else if (p_board[0].get() == 'O' && p_board[2].get() == 'O' && (p_board[1].get() != 'X' && p_board[1].get() != 'O'))
                p_board[1].set('O');
            else if (p_board[0].get() == 'O' && p_board[3].get() == 'O' && (p_board[6].get() != 'X' && p_board[6].get() != 'O'))
                p_board[6].set('O');
            else if (p_board[0].get() == 'O' && p_board[4].get() == 'O' && (p_board[8].get() != 'X' && p_board[8].get() != 'O'))
                p_board[8].set('O');
            else if (p_board[0].get() == 'O' && p_board[6].get() == 'O' && (p_board[3].get() != 'X' && p_board[3].get() != 'O'))
                p_board[3].set('O');
            else if (p_board[1].get() == 'O' && p_board[2].get() == 'O' && (p_board[0].get() != 'X' && p_board[0].get() != 'O'))
                p_board[0].set('O');
            else if (p_board[1].get() == 'O' && p_board[4].get() == 'O' && (p_board[7].get() != 'X' & p_board[7].get() != 'O'))
                p_board[7].set('O');
            else if (p_board[2].get() == 'O' && p_board[5].get() == 'O' && (p_board[8].get() != 'X' && p_board[8].get() != 'O'))
                p_board[8].set('O');
            else if (p_board[2].get() == 'O' && p_board[4].get() == 'O' && (p_board[6].get() != 'X' && p_board[6].get() != 'O'))
                p_board[6].set('O');
            else if (p_board[2].get() == 'O' && p_board[8].get() == 'O' && (p_board[5].get() != 'X' && p_board[5].get() != 'O'))
                p_board[5].set('O');
            else if (p_board[5].get() == 'O' && p_board[8].get() == 'O' && (p_board[2].get() != 'X' && p_board[2].get() != 'O'))
                p_board[2].set('O');
            else if (p_board[7].get() == 'O' && p_board[8].get() == 'O' && (p_board[6].get() != 'X' && p_board[6].get() != 'O'))
                p_board[6].set('O');
            else if (p_board[4].get() == 'O' && p_board[5].get() == 'O' && (p_board[3].get() != 'X' && p_board[3].get() != 'O'))
                p_board[3].set('O');
            else if (p_board[4].get() == 'O' && p_board[7].get() == 'O' && (p_board[1].get() != 'X' && p_board[1].get() != 'O'))
                p_board[1].set('O');
            else if (p_board[4].get() == 'O' && p_board[8].get() == 'O' && (p_board[0].get() != 'X' && p_board[0].get() != 'O'))
                p_board[0].set('O');
            else if (p_board[3].get() == 'O' && p_board[6].get() == 'O' && (p_board[0].get() != 'X' && p_board[0].get() != 'O'))
                p_board[0].set('O');
            else if (p_board[3].get() == 'O' && p_board[4].get() == 'O' && (p_board[5].get() != 'X' && p_board[5].get() != 'O'))
                p_board[5].set('O');
            else if (p_board[4].get() == 'O' && p_board[6].get() == 'O' && (p_board[2].get() != 'X' && p_board[2].get() != 'O'))
                p_board[2].set('O');
            else if (p_board[6].get() == 'O' && p_board[7].get() == 'O' && (p_board[8].get() != 'X' && p_board[8].get() != 'O'))
                p_board[8].set('O');
            else if (p_board[6].get() == 'O' && p_board[8].get() == 'O' && (p_board[7].get() != 'X' && p_board[7].get() != 'O'))
                p_board[7].set('O');
            else if (p_board[0].get() == 'X' && p_board[1].get() == 'X' && (p_board[2].get() != 'X' && p_board[2].get() != 'O'))
                p_board[2].set('O');
            else if (p_board[0].get() == 'X' && p_board[3].get() == 'X' && (p_board[6].get() != 'X' && p_board[6].get() != 'O'))
                p_board[6].set('O');
            else if (p_board[0].get() == 'X' && p_board[4].get() == 'X' && (p_board[8].get() != 'X' && p_board[8].get() != 'O'))
                p_board[8].set('O');
            else if (p_board[0].get() == 'X' && p_board[2].get() == 'X' && (p_board[1].get() != 'X' && p_board[1].get() != 'O'))
                p_board[1].set('O');
            else if (p_board[0].get() == 'X' && p_board[6].get() == 'X' && (p_board[3].get() != 'X' && p_board[3].get() != 'O'))
                p_board[3].set('O');
            else if (p_board[1].get() == 'X' && p_board[2].get() == 'X' && (p_board[0].get() != 'X' && p_board[0].get() != 'O'))
                p_board[0].set('O');
            else if (p_board[1].get() == 'X' && p_board[4].get() == 'X' && (p_board[7].get() != 'X' && p_board[7].get() != 'O'))
                p_board[7].set('O');
            else if (p_board[2].get() == 'X' && p_board[5].get() == 'X' && (p_board[8].get() != 'X' && p_board[8].get() != 'O'))
                p_board[8].set('O');
            else if (p_board[2].get() == 'X' && p_board[4].get() == 'X' && (p_board[6].get() != 'X' && p_board[6].get() != 'O'))
                p_board[6].set('O');
            else if (p_board[2].get() == 'X' && p_board[8].get() == 'X' && (p_board[5].get() != 'X' && p_board[5].get() != 'O'))
                p_board[5].set('O');
            else if (p_board[5].get() == 'X' && p_board[8].get() == 'X' && (p_board[2].get() != 'X' && p_board[2].get() != 'O'))
                p_board[2].set('O');
            else if (p_board[7].get() == 'X' && p_board[8].get() == 'X' && (p_board[6].get() != 'X' && p_board[6].get() != 'O'))
                p_board[6].set('O');
            else if (p_board[4].get() == 'X' && p_board[7].get() == 'X' && (p_board[1].get() != 'X' && p_board[1].get() != 'O'))
                p_board[1].set('O');
            else if (p_board[4].get() == 'X' && p_board[8].get() == 'X' && (p_board[0].get() != 'X' && p_board[0].get() != 'O'))
                p_board[0].set('O');
            else if (p_board[3].get() == 'X' && p_board[4].get() == 'X' && (p_board[5].get() != 'X' && p_board[5].get() != 'O'))
                p_board[5].set('O');
            else if (p_board[3].get() == 'X' && p_board[6].get() == 'X' && (p_board[0].get() != 'X' && p_board[0].get() != 'O'))
                p_board[0].set('O');
            else if (p_board[4].get() == 'X' && p_board[5].get() == 'X' && (p_board[3].get() != 'X' && p_board[3].get() != 'O'))
                p_board[3].set('O');
            else if (p_board[4].get() == 'X' && p_board[6].get() == 'X' && (p_board[2].get() != 'X' && p_board[2].get() != 'O'))
                p_board[2].set('O');
            else if (p_board[6].get() == 'X' && p_board[7].get() == 'X' && (p_board[8].get() != 'X' && p_board[8].get() != 'O'))
                p_board[8].set('O');
            else if (p_board[6].get() == 'X' && p_board[8].get() == 'X' && (p_board[7].get() != 'X' && p_board[7].get() != 'O'))
                p_board[7].set('O');
            else
                test_computermove();

        }
    }

    void test_computermove()
    {
        int x;
        x = rand() % 9;

        if (p_board[x].get() == 'X' || p_board[x].get() == 'O')
            test_computermove();
        else
            p_board[x].set('O');
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // The following functions are legal Java, but are not really in typical Java style. Instead they are there to
    // simulate things that you can do in C but can't do the same way in Java

    static class CharPointer
    {
        final char[] sourceArray;
        final int index;

        public CharPointer(char[] sourceArray, int index)
        {
            this.sourceArray = sourceArray;
            this.index = index;
        }

        public char get()
        {
            return sourceArray[index];
        }

        public char set(char newValue)
        {
            sourceArray[index] = newValue;
            return newValue;
        }
    }

    static CharPointer addressOf(char[][] jaggedArray, int outerIndex, int innerIndex)
    {
        return new CharPointer(jaggedArray[outerIndex], innerIndex);
    }

    static Random staticRand = new Random();

    static void srand(long seed)
    {
        staticRand = new Random(seed);
    }

    static long time()
    {
        return System.currentTimeMillis();
    }

    static void printf(String format, Object... args)
    {
        System.out.printf(format, args);
    }

    static final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    static char getchar()
    {
        try
        {
            return stdin.readLine().trim().charAt(0);
        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    static int rand()
    {
        return Math.abs(staticRand.nextInt());
    }

    static void printRow(char[] row)
    {
        for (int i = 0; i < row.length; i++)
        {
            if (row[i] != '\0')
            {
                System.out.print(row[i]);
            }
        }
        System.out.print(" \n");

    }
}
