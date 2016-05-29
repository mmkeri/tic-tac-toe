//
//
#define _CRT_SECURE_NO_WARNINGS

//#include "stdafx.h"
#include "stdio.h"
#include "conio.h"
#include "time.h"
#include "stdlib.h"

#define HEIGHT 5
#define WIDTH 6


void applyplayer1(int move);
void applyplayer2(int move);
void test_move1(char *ptr);
void test_move2(char *ptr);
int testplayer1win();
int testplayer2win();
void computer_move(int turns);
void test_computermove();

int player1;
int player2;

char board[HEIGHT][WIDTH] =
{ { '1', '|', '2', '|', '3', '\0' },
{ '-', '-', '-', '-', '-', '\0' },
{ '4', '|', '5', '|', '6', '\0' },
{ '-', '-', '-', '-', '-', '\0' },
{ '7', '|', '8', '|', '9', '\0' } };

char *p_board[9] = { &board[0][0], &board[0][2], &board[0][4], &board[2][0], &board[2][2],
&board[2][4], &board[4][0], &board[4][2], &board[4][4] };

int main()
{

	int x = 0;
	char choice;
	int turns = 0;
	int winner = 0;
	char player_input[10];
	int values_required = 0;
	srand(time(NULL));

	printf("Welcome to Tic Tac Toe.\n");
	printf("You can play against another person or the computer.\n");
	printf("Choose your opponent ('C' for the computer or 'P' for player)\n");
	scanf("%c", &choice);
	getchar();
	if (choice != 'C' && choice != 'c')
	{
		for (x = 0; x < HEIGHT; x++)
		{
			printf("%s \n", board[x]);
		}

		for (turns = 0; turns < 9 && winner == 0; turns++)
		{
			if (turns % 2 == 0)
			{
				printf("Player one please choose a space to play in: \n");
				player1 = getchar();
				while (getchar() != '\n');/*used to "eat up" any extra keyboard input that might result in an infinite loop*/
				applyplayer1(player1);
				for (x = 0; x < HEIGHT; x++)
				{
					printf("%s \n", board[x]);
				}
				printf("\n\n");
				testplayer1win();
				winner = testplayer1win();
			}
			if (turns % 2 == 1)
			{
				printf("Player two please choose a space to play in: \n");
				player2 = getchar();/* converts the input to its ASCII code*/
				while (getchar() != '\n');
				applyplayer2(player2);
				for (x = 0; x < HEIGHT; x++)
				{
					printf("%s \n", board[x]);
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
			printf("%s \n", board[x]);
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
				while (getchar() != '\n');/*used to "eat up" any extra keyboard input that might result in an infinite loop*/
				applyplayer1(player1);
				for (x = 0; x < HEIGHT; x++)
				{
					printf("%s \n", board[x]);
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
					printf("%s \n", board[x]);
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
			while (getchar() != '\n');
			applyplayer1(alt_move);
			break;
		}
	case '1':
		{
			test_move1(p_board[0]);
			*p_board[0] = 'X';
			break;
		}
	case '2':
		{
			test_move1(p_board[1]);
			*p_board[1] = 'X';
			break;
		}
	case '3':
		{
			test_move1(p_board[2]);
			*p_board[2] = 'X';
			break;
		}
	case '4':
		{
			test_move1(p_board[3]);
			*p_board[3] = 'X';
			break;
		}
	case '5':
		{
			test_move1(p_board[4]);
			*p_board[4] = 'X';
			break;
		}
	case '6':
		{
			test_move1(p_board[5]);
			*p_board[5] = 'X';
			break;
		}
	case '7':
		{
			test_move1(p_board[6]);
			*p_board[6] = 'X';
			break;
		}
	case '8':
		{
			test_move1(p_board[7]);
			*p_board[7] = 'X';
			break;
		}
	case '9':
		{
			test_move1(p_board[8]);
			*p_board[8] = 'X';
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
			while (getchar() != '\n');/*used to "eat up" any extra keyboard input that might result in an infinite loop*/
			applyplayer2(alt_move);
			break;
		}
	case '1':
		{
			test_move2(p_board[0]);
			*p_board[0] = 'O';
			break;
		}
	case '2':
		{
			test_move2(p_board[1]);
			*p_board[1] = 'O';
			break;
		}
	case '3':
		{
			test_move2(p_board[2]);
			*p_board[2] = 'O';
			break;
		}
	case '4':
		{
			test_move2(p_board[3]);
			*p_board[3] = 'O';
			break;
		}
	case '5':
		{
			test_move2(p_board[4]);
			*p_board[4] = 'O';
			break;
		}
	case '6':
		{
			test_move2(p_board[5]);
			*p_board[5] = 'O';
			break;
		}
	case '7':
		{
			test_move2(p_board[6]);
			*p_board[6] = 'O';
			break;
		}
	case '8':
		{
			test_move2(p_board[7]);
			*p_board[7] = 'O';
			break;
		}
	case '9':
		{
			test_move2(p_board[8]);
			*p_board[8] = 'O';
			break;
		}
	}
}
/* Tests the players move against those already made to see if the player
has won. Identical to testplayer2*/
int testplayer1win()
{

	if (*p_board[0] == 'X' && *p_board[1] == 'X' && *p_board[2] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else if (*p_board[3] == 'X' && *p_board[4] == 'X' && *p_board[5] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else if (*p_board[6] == 'X' && *p_board[7] == 'X' && *p_board[8] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else if (*p_board[0] == 'X' && *p_board[3] == 'X' && *p_board[6] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else if (*p_board[1] == 'X' && *p_board[4] == 'X' && *p_board[7] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else if (*p_board[2] == 'X' && *p_board[5] == 'X' && *p_board[8] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else if (*p_board[0] == 'X' && *p_board[4] == 'X' && *p_board[8] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else if (*p_board[2] == 'X' && *p_board[4] == 'X' && *p_board[6] == 'X')
	{
		printf("Player 1 wins!");
		return 1;
	}
	else {
		return 0;
	}
}

int testplayer2win()
{

	if (*p_board[0] == 'O' && *p_board[1] == 'O' && *p_board[2] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else if (*p_board[3] == 'O' && *p_board[4] == 'O' && *p_board[5] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else if (*p_board[6] == 'O' && *p_board[7] == 'O' && *p_board[8] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else if (*p_board[0] == 'O' && *p_board[3] == 'O' && *p_board[6] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else if (*p_board[1] == 'O' && *p_board[4] == 'O' && *p_board[7] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else if (*p_board[2] == 'O' && *p_board[5] == 'O' && *p_board[8] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else if (*p_board[0] == 'O' && *p_board[4] == 'O' && *p_board[8] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else if (*p_board[2] == 'O' && *p_board[4] == 'O' && *p_board[6] == 'O')
	{
		printf("Player 2 wins!");
		return 1;
	}
	else {
		return 0;
	}
}

/*Tests to see if the move chosen by the player is to a space already
occupied on the board. Results in an error message if this is true and
prompts the player to make another move/selection. Identical to test_move2*/
void test_move1(char *p_board)
{
	int alt_move;

	if (*p_board == 'X' || *p_board == 'O')
	{
		printf("Illegal move! Try again.\n");
		printf("Please try another move: ");
		alt_move = getchar();
		while (getchar() != '\n');/*used to "eat up" any extra keyboard input that might result in an infinite loop*/
		applyplayer1(alt_move);
	}
	else {
		return;
	}
}

void test_move2(char *ptr)
{
	int alt_move;

	if (*ptr == 'X' || *ptr == 'O')
	{
		printf("Illegal move! Try again.\n");
		printf("Please try another move: ");
		alt_move = getchar();
		while (getchar() != '\n');
		applyplayer2(alt_move);
	}
	else {
		return;
	}
}



void computer_move(int turns)
{

	if (turns == 1)
	{
		if (*p_board[4] == 'X')
		{
			int nextmove;
			for (nextmove = rand() % 9; nextmove == 4; nextmove = rand() % 9)
				;
			*p_board[nextmove] = 'O';
		}
		else
		{
			*p_board[4] = 'O';
		}
	}
	else
	{
		if (*p_board[0] == 'O' && *p_board[1] == 'O' && (*p_board[2] != 'X' && *p_board[2] != 'O'))
			*p_board[2] = 'O';
		else if (*p_board[0] == 'O' && *p_board[2] == 'O' && (*p_board[1] != 'X' && *p_board[1] != 'O'))
			*p_board[1] = 'O';
		else if (*p_board[0] == 'O' && *p_board[3] == 'O' && (*p_board[6] != 'X' && *p_board[6] != 'O'))
			*p_board[6] = 'O';
		else if (*p_board[0] == 'O' && *p_board[4] == 'O' && (*p_board[8] != 'X' && *p_board[8] != 'O'))
			*p_board[8] = 'O';
		else if (*p_board[0] == 'O' && *p_board[6] == 'O' && (*p_board[3] != 'X' && *p_board[3] != 'O'))
			*p_board[3] = 'O';
		else if (*p_board[1] == 'O' && *p_board[2] == 'O' && (*p_board[0] != 'X' && *p_board[0] != 'O'))
			*p_board[0] = 'O';
		else if (*p_board[1] == 'O' && *p_board[4] == 'O' && (*p_board[7] != 'X' & *p_board[7] != 'O'))
			*p_board[7] = 'O';
		else if (*p_board[2] == 'O' && *p_board[5] == 'O' && (*p_board[8] != 'X' && *p_board[8] != 'O'))
			*p_board[8] = 'O';
		else if (*p_board[2] == 'O' && *p_board[4] == 'O' && (*p_board[6] != 'X' && *p_board[6] != 'O'))
			*p_board[6] = 'O';
		else if (*p_board[2] == 'O' && *p_board[8] == 'O' && (*p_board[5] != 'X' && *p_board[5] != 'O'))
		*p_board[5] = 'O';
		else if (*p_board[5] == 'O' && *p_board[8] == 'O' && (*p_board[2] != 'X' && *p_board[2] != 'O'))
			*p_board[2] = 'O';
		else if (*p_board[7] == 'O' && *p_board[8] == 'O' && (*p_board[6] != 'X' && *p_board[6] != 'O'))
			*p_board[6] = 'O';
		else if (*p_board[4] == 'O' && *p_board[5] == 'O' && (*p_board[3] != 'X' && *p_board[3] != 'O'))
			*p_board[3] = 'O';
		else if (*p_board[4] == 'O' && *p_board[7] == 'O' && (*p_board[1] != 'X' && *p_board[1] != 'O'))
			*p_board[1] = 'O';
		else if (*p_board[4] == 'O' && *p_board[8] == 'O' && (*p_board[0] != 'X' && *p_board[0] != 'O'))
			*p_board[0] = 'O';
		else if (*p_board[3] == 'O' && *p_board[6] == 'O' && (*p_board[0] != 'X' && *p_board[0] != 'O'))
			*p_board[0] = 'O';
		else if (*p_board[3] == 'O' && *p_board[4] == 'O' && (*p_board[5] != 'X' && *p_board[5] != 'O'))
			*p_board[5] = 'O';
		else if (*p_board[4] == 'O' && *p_board[6] == 'O' && (*p_board[2] != 'X' && *p_board[2] != 'O'))
			*p_board[2] = 'O';
		else if (*p_board[6] == 'O' && *p_board[7] == 'O' && (*p_board[8] != 'X' && *p_board[8] != 'O'))
			*p_board[8] = 'O';
		else if (*p_board[6] == 'O' && *p_board[8] == 'O' && (*p_board[7] != 'X' && *p_board[7] != 'O'))
			*p_board[7] = 'O';
		else if (*p_board[0] == 'X' && *p_board[1] == 'X' && (*p_board[2] != 'X' && *p_board[2] != 'O'))
			*p_board[2] = 'O';
		else if (*p_board[0] == 'X' && *p_board[3] == 'X' && (*p_board[6] != 'X' && *p_board[6] != 'O'))
			*p_board[6];
		else if (*p_board[0] == 'X' && *p_board[4] == 'X' && (*p_board[8] != 'X' && *p_board[8] != 'O'))
			*p_board[8] = 'O';
		else if (*p_board[0] == 'X' && *p_board[2] == 'X' && (*p_board[1] != 'X' && *p_board[1] != 'O'))
			*p_board[1] = 'O';
		else if (*p_board[0] == 'X' && *p_board[6] == 'X' && (*p_board[3] != 'X' && *p_board[3] != 'O'))
			*p_board[3] = 'O';
		else if (*p_board[1] == 'X' && *p_board[2] == 'X' && (*p_board[0] != 'X' && *p_board[0] != 'O'))
			*p_board[0] = 'O';
		else if (*p_board[1] == 'X' && *p_board[4] == 'X' && (*p_board[7] != 'X' && *p_board[7] != 'O'))
			*p_board[7] = 'O';
		else if (*p_board[2] == 'X' && *p_board[5] == 'X' && (*p_board[8] != 'X' && *p_board[8] != 'O'))
			*p_board[8] = 'O';
		else if (*p_board[2] == 'X' && *p_board[4] == 'X' && (*p_board[6] != 'X' && *p_board[6] != 'O'))
			*p_board[6] = 'O';
		else if (*p_board[2] == 'X' && *p_board[8] == 'X' && (*p_board[5] != 'X' && *p_board[5] != 'O'))
			*p_board[5] = 'O';
		else if (*p_board[5] == 'X' && *p_board[8] == 'X' && (*p_board[2] != 'X' && *p_board[2] != 'O'))
			*p_board[2] = 'O';
		else if (*p_board[7] == 'X' && *p_board[8] == 'X' && (*p_board[6] != 'X' && *p_board[6] != 'O'))
			*p_board[6] = 'O';
		else if (*p_board[4] == 'X' && *p_board[7] == 'X' && (*p_board[1] != 'X' && *p_board[1] != 'O'))
			*p_board[1] = 'O';
		else if (*p_board[4] == 'X' && *p_board[8] == 'X' && (*p_board[0] != 'X' && *p_board[0] != 'O'))
			*p_board[0] = 'O';
		else if (*p_board[3] == 'X' && *p_board[4] == 'X' && (*p_board[5] != 'X' && *p_board[5] != 'O'))
			*p_board[5] = 'O';
		else if (*p_board[3] == 'X' && *p_board[6] == 'X' && (*p_board[0] != 'X' && *p_board[0] != 'O'))
			*p_board[0] = 'O';
		else if (*p_board[4] == 'X' && *p_board[5] == 'X' && (*p_board[3] != 'X' && *p_board[3] != 'O'))
			*p_board[3] = 'O';
		else if (*p_board[4] == 'X' && *p_board[6] == 'X' && (*p_board[2] != 'X' && *p_board[2] != 'O'))
			*p_board[2] = 'O';
		else if (*p_board[6] == 'X' && *p_board[7] == 'X' && (*p_board[8] != 'X' && *p_board[8] != 'O'))
			*p_board[8] = 'O';
		else if (*p_board[6] == 'X' && *p_board[8] == 'X' && (*p_board[7] != 'X' && *p_board[7] != 'O'))
			*p_board[7] = 'O';
		else
			test_computermove();

	}
}

void test_computermove()
{
	int x;
	x = rand() % 9;

	if (*p_board[x] == 'X' || *p_board[x] == 'O')
		test_computermove();
	else
		*p_board[x] = 'O';
}


